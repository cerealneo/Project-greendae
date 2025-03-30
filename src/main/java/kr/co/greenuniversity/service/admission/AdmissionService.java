package kr.co.greenuniversity.service.admission;

import kr.co.greenuniversity.dto.admission.NoticeDTO;
import kr.co.greenuniversity.entity.admission.Notice;
import kr.co.greenuniversity.repository.admission.AdmissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdmissionService {

    private final AdmissionRepository admissionRepository;

    public List<NoticeDTO> findAll() {

        // SELECTALLLIST 메서드를 한 번만 호출하여 리스트를 가져옴
        List<Notice> noticeList = admissionRepository.SELECTALLLIST();

        // Notice 엔티티를 NoticeDTO로 변환하여 리턴
        return noticeList.stream()
                .map(Notice::toDTO)  // Notice 객체에서 toDTO 메서드를 호출
                .collect(Collectors.toList());
    }
}


