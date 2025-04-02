package kr.co.greenuniversity.controller.community;


import jakarta.servlet.http.HttpServletRequest;
import kr.co.greenuniversity.dto.file.FileDTO;
import kr.co.greenuniversity.dto.community.Community2DTO;
import kr.co.greenuniversity.dto.community.Community1DTO;
import kr.co.greenuniversity.service.community.CommunityService;
import kr.co.greenuniversity.service.file.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class CommunityController {

    private final CommunityService communityService;
    private final FileService fileService;

    // 글 보기
    @GetMapping("/Community/view1")
    public String view1(int no, @RequestParam("cate") String cate, Model model) {
        Community1DTO communityDTO = communityService.findById1(no);
        model.addAttribute(communityDTO);
        model.addAttribute("cate", cate);
        return "Community/view/view1";
    }

    @GetMapping("/Community/view2")
    public String view2(int no, @RequestParam("cate") String cate, Model model) {
        Community2DTO communityDTO = communityService.findById2(no);
        model.addAttribute(communityDTO);
        model.addAttribute("cate", cate);
        return "/Community/view/view2";
    }

    @GetMapping("/Community/view3")
    public String view3(int no, @RequestParam("cate") String cate, Model model) {
        Community2DTO communityDTO = communityService.findById2(no);
        model.addAttribute(communityDTO);
        model.addAttribute("cate", cate);
        return "/Community/view/view3";
    }

    @GetMapping("/Community/view4")
    public String view4(int no, @RequestParam("cate") String cate, Model model) {
        Community2DTO communityDTO = communityService.findById2(no);
        model.addAttribute(communityDTO);
        model.addAttribute("cate", cate);
        return "/Community/view/view4";
    }


    // 글 쓰기
    @GetMapping("/Community/write1")
    public String write1(@RequestParam("cate") String cate, Model model) {
        model.addAttribute("cate", cate);
        return "Community/write/write1";
    }

    @GetMapping("/Community/write2")
    public String write2(@RequestParam("cate") String cate, Model model) {
        model.addAttribute("cate", cate);
        return "Community/write/write2";
    }

    @GetMapping("/Community/write3")
    public String write3(@RequestParam("cate") String cate, Model model) {
        model.addAttribute("cate", cate);
        return "Community/write/write3";
    }

    @GetMapping("/Community/write4")
    public String write4(@RequestParam("cate") String cate, Model model) {
        model.addAttribute("cate", cate);
        return "Community/write/write4";
    }

    @PostMapping("/Community/write1")
    public String write1(Community1DTO communityDTO, HttpServletRequest req) {

        String regip = req.getRemoteAddr();
        communityDTO.setRegip(regip);

        List<FileDTO> files = fileService.uploadFile1(communityDTO);

        communityDTO.setFile(files.size());
        int no = communityService.register1(communityDTO);

        for(FileDTO fileDTO : files) {
            fileDTO.setAno(no);
            fileService.save(fileDTO);
        }

        String cate = communityDTO.getCate();
        return "redirect:/Community/" + cate;
    }

    @PostMapping("/Community/write2")
    public String write2(Community2DTO communityDTO, HttpServletRequest req) {

        String regip = req.getRemoteAddr();
        communityDTO.setRegip(regip);

        log.info("communityDTO: " + communityDTO);

        List<FileDTO> files = fileService.uploadFile2(communityDTO);

        communityDTO.setFile(files.size());
        int no = communityService.register2(communityDTO);

        for(FileDTO fileDTO : files) {
            fileDTO.setAno(no);
            fileService.save(fileDTO);
        }

        String cate = communityDTO.getCate();
        return "redirect:/Community/" + cate;
    }


}
