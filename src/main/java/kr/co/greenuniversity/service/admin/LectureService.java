package kr.co.greenuniversity.service.admin;

import kr.co.greenuniversity.entity.Department;
import kr.co.greenuniversity.entity.Lecture;
import kr.co.greenuniversity.repository.DepartmentRepository;
import kr.co.greenuniversity.repository.LectureRepository;
import kr.co.greenuniversity.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Slf4j
@RequiredArgsConstructor
public class LectureService {

    private final ProfessorRepository professorRepository;
    private final ModelMapper modelMapper;
    private final DepartmentRepository departmentRepository;
    private final LectureRepository lectureRepository;

    public void registerLecture(Lecture lecture, String departmentName) {

        Department dept = departmentRepository.findByDepartmentName(departmentName)
                .orElseThrow(() -> new IllegalArgumentException("Department not found"));

        String generatedCode = generateLectureCode(dept);
        lecture.setCode(generatedCode);
        lecture.setDepNo(String.valueOf(dept.getNo()));
        lecture.setColName(dept.getCollege().getCollegeName());
        lecture.setDepName(dept.getDepartmentName());

        lectureRepository.save(lecture);
    }

    public String generateLectureCode(Department dept) {
        String depNo = String.format("%02d", dept.getNo());
        String year = String.valueOf(LocalDate.now().getYear());
        int semester = ThreadLocalRandom.current().nextInt(1, 3); // 1 or 2

        // 순번 계산
        String startDate = year; // 연도로 계산 (또는 학기 포함해서 변경 가능)
        int count = lectureRepository.countByDepNoAndStartDate(depNo, startDate);
        String seq = String.format("%02d", count + 1);

        return depNo + year + semester + seq;
    }




}
