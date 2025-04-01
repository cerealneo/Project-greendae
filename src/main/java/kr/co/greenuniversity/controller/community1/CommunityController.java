package kr.co.greenuniversity.controller.community1;


import jakarta.servlet.http.HttpServletRequest;
import kr.co.greenuniversity.dto.FileDTO;
import kr.co.greenuniversity.dto.PageRequestDTO;
import kr.co.greenuniversity.dto.PageResponseDTO;
import kr.co.greenuniversity.dto.community.CommunityDTO1;
import kr.co.greenuniversity.service.community1.CommunityService;
import kr.co.greenuniversity.service.file.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class CommunityController {

    private final CommunityService communityService;
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
        log.info(pageRequestDTO.toString());
        PageResponseDTO pageResponseDTO = communityService.searchAll(pageRequestDTO);
        model.addAttribute(pageResponseDTO);
        return "/Community/search/searchResource";
    }


    // 글 보기
    @GetMapping("/Community/view")
    public String view(int no, Model model) {
        CommunityDTO1 communityDTO = communityService.findById(no);
        log.info("communityDTO: {}", communityDTO);
        model.addAttribute(communityDTO);
        return "/Community/view";
    }


    // 글 쓰기
    @GetMapping("/Community/write")
    public String write() {
        return "/Community/write";
    }

    @PostMapping("/Community/write")
    public String write(CommunityDTO1 communityDTO, HttpServletRequest req) {

        String regip = req.getRemoteAddr();
        communityDTO.setRegip(regip);

        List<FileDTO> files = fileService.uploadFile(communityDTO);

        communityDTO.setFile(files.size());
        int no = communityService.register(communityDTO);

        for(FileDTO fileDTO : files) {
            fileDTO.setArticle_no(no);
            fileService.save(fileDTO);
        }

        return "redirect:/Community/write";
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
