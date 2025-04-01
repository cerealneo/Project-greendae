document.addEventListener('DOMContentLoaded', function() {
    let today = new Date();
    let currentMonth = today.getMonth() + 1;  // JavaScript에서 month는 0부터 시작하므로 +1
    let currentYear = today.getFullYear();

    function fetchEvents(year, month) {
        // 절대 URL로 변경하여 요청 보내기
        fetch(`/api/bachelor/schedule/${year}/${month}`)
            .then(response => response.json())
            .then(data => {
                console.log("📅 일정 데이터:", data);
                renderCalendar(month - 1, year, data); // month -1은 JavaScript의 Date 기준에 맞추기 위함
            })
            .catch(error => console.error("데이터 불러오기 실패:", error));
    }

    function renderCalendar(month, year, events) {
        let firstDay = new Date(year, month, 1).getDay();
        let daysInMonth = new Date(year, month + 1, 0).getDate();
        let calendarBody = document.getElementById("calendar-body");
        let monthYear = document.getElementById("month-year");

        const monthNames = [
            "01", "02", "03", "04", "05", "06",
            "07", "08", "09", "10", "11", "12"
        ];

        monthYear.innerText = `${year}. ${monthNames[month]}`;
        calendarBody.innerHTML = "";

        let date = 1;
        let nextMonthDate = 1;
        let lastMonthDays = new Date(year, month, 0).getDate();

        for (let i = 0; i < 6; i++) {
            let row = document.createElement("tr");

            for (let j = 0; j < 7; j++) {
                let cell = document.createElement("td");

                // 이전 달 날짜
                if (i === 0 && j < firstDay) {
                    cell.innerText = lastMonthDays - firstDay + j + 1;
                    cell.classList.add("other-month");
                }
                // 현재 달 날짜
                else if (date <= daysInMonth) {
                    cell.innerText = date;
                    cell.dataset.date = `${year}-${monthNames[month]}-${String(date).padStart(2, "0")}`;

                    // 📌 일정이 있는 날짜에 표시 추가
                    let event = events.find(e => e.eventDate === cell.dataset.date);  // 날짜 비교 수정
                    console.log("캘린더 날짜:", cell.dataset.date);  // 날짜 로그 추가
                    console.log("이벤트 날짜:", event ? event.eventDate : "없음");  // 이벤트 로그 추가

                    if (event) {
                        let eventMarker = document.createElement("div");
                        eventMarker.classList.add("event-marker");
                        eventMarker.innerText = event.title;
                        cell.appendChild(eventMarker);
                    }

                    date++;
                }
                // 다음 달 날짜
                else {
                    cell.innerText = nextMonthDate;
                    cell.classList.add("other-month");
                    nextMonthDate++;
                }

                row.appendChild(cell);
            }
            calendarBody.appendChild(row);
        }
    }


    function prevMonth() {
        if (currentMonth === 1) {
            currentYear--;
            currentMonth = 12;
        } else {
            currentMonth--;
        }
        fetchEvents(currentYear, currentMonth);
    }

    function nextMonth() {
        if (currentMonth === 12) {
            currentYear++;
            currentMonth = 1;
        } else {
            currentMonth++;
        }
        fetchEvents(currentYear, currentMonth);
    }

    document.getElementById("prev-btn").addEventListener("click", prevMonth);
    document.getElementById("next-btn").addEventListener("click", nextMonth);

    fetchEvents(currentYear, currentMonth);
});
