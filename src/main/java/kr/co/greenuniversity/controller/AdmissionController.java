package kr.co.greenuniversity.controller;

import kr.co.greenuniversity.dto.admission.NoticeDTO;
import kr.co.greenuniversity.service.admission.AdmissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AdmissionController {

    private final AdmissionService admissionService;

    @GetMapping("/Admission/admissionCounseling")
    public String admissionCounseling () {
        return "/Admission/admissionCounseling";
    }

    @GetMapping("/Admission/earlyAdmission")
    public String earlyAdmission() {
        return "/Admission/earlyAdmission";
    }

    @GetMapping("/Admission/notice")
    public String notice(Model model) {

        List<NoticeDTO> noticeDTOList  = admissionService.findAll();

        log.info("noticeDTOList :  {}", noticeDTOList);

        model.addAttribute(noticeDTOList);

        return "/Admission/notice";
    }

    @GetMapping("/Admission/regularAdmission")
    public String regularAdmission() {
        return "/Admission/regularAdmission";
    }

    @GetMapping("/Admission/transferAdmission")
    public String transferAdmission() {
        return "/Admission/transferAdmission";
    }
}
