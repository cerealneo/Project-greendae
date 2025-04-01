package kr.co.greenuniversity.controller.community;


import kr.co.greenuniversity.dto.page.PageRequestDTO;
import kr.co.greenuniversity.dto.page.PageResponseDTO;
import kr.co.greenuniversity.service.community.Community1Service;
import kr.co.greenuniversity.service.file.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class Community1Controller {

    private final Community1Service communityService;
    private final FileService fileService;

    // 목록
    @GetMapping("Community/notice")
    public String notice(PageRequestDTO pageRequestDTO, Model model) {
        pageRequestDTO.setCate("notice");
        PageResponseDTO pageResponseDTO = communityService.findAll(pageRequestDTO);
        model.addAttribute(pageResponseDTO);
        return "/Community/notice";
    }

    @GetMapping("/Community/free")
    public String free(PageRequestDTO pageRequestDTO, Model model) {
        PageResponseDTO pageResponseDTO = communityService.findAll(pageRequestDTO);
        model.addAttribute(pageResponseDTO);
        return "/Community/free";
    }

    @GetMapping("/Community/resource")
    public String resource(PageRequestDTO pageRequestDTO, Model model) {
        pageRequestDTO.setCate("resource");
        PageResponseDTO pageResponseDTO = communityService.findAll(pageRequestDTO);
        model.addAttribute(pageResponseDTO);
        return "/Community/resource";
    }


    // 검색
    @GetMapping("/Community/searchNotice")
    public String searchNotice(PageRequestDTO pageRequestDTO, Model model) {
        pageRequestDTO.setCate("notice");
        PageResponseDTO pageResponseDTO = communityService.searchAll(pageRequestDTO);
        model.addAttribute(pageResponseDTO);
        return "/Community/search/searchNotice";
    }

    @GetMapping("/Community/searchFree")
    public String searchFree(PageRequestDTO pageRequestDTO, Model model) {
        PageResponseDTO pageResponseDTO = communityService.searchAll(pageRequestDTO);
        model.addAttribute(pageResponseDTO);
        return "/Community/search/searchFree";
    }

    @GetMapping("/Community/searchResource")
    public String searchResource(PageRequestDTO pageRequestDTO, Model model) {
        pageRequestDTO.setCate("resource");
        PageResponseDTO pageResponseDTO = communityService.searchAll(pageRequestDTO);
        model.addAttribute(pageResponseDTO);
        return "/Community/search/searchResource";
    }


}
