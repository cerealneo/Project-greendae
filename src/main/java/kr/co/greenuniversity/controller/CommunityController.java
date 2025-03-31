package kr.co.greenuniversity.controller;


import kr.co.greenuniversity.dto.PageRequestDTO;
import kr.co.greenuniversity.dto.PageResponseDTO;
import kr.co.greenuniversity.dto.community.CommunityDTO;
import kr.co.greenuniversity.service.community1.CommunityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class CommunityController {

    private final CommunityService communityService;

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
        log.info(pageRequestDTO.toString());
        PageResponseDTO pageResponseDTO = communityService.searchAll(pageRequestDTO);
        model.addAttribute(pageResponseDTO);
        return "/Community/search/searchResource";
    }

    // 글 보기
    @GetMapping("/Community/view")
    public String view(int no, Model model) {
        CommunityDTO communityDTO = communityService.findById(no);
        model.addAttribute(communityDTO);
        return "/Community/view";
    }


    @GetMapping("/Community/job")
    public String job() {
        return "/Community/job";
    }

    @GetMapping("/Community/news")
    public String news() {
        return "/Community/news";
    }

    @GetMapping("Community/qa")
    public String qa() {
        return "/Community/qa";
    }

}
