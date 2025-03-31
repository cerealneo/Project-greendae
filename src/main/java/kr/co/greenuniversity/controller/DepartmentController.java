package kr.co.greenuniversity.controller;

import kr.co.greenuniversity.dto.DepartmentDTO;
import kr.co.greenuniversity.entity.College;
import kr.co.greenuniversity.entity.Department;
import kr.co.greenuniversity.repository.CollegeRepository;
import kr.co.greenuniversity.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RequiredArgsConstructor
@Controller
public class DepartmentController {

    private final DepartmentService departmentService;
    private final CollegeRepository collegeRepository;

    @GetMapping("/Management/ManageDepartregist")
    public String registerDepartment(){
        return "/Management/ManageDepartregist";
    }

    @PostMapping("/Management/registerDepart")
    public String registerDepartment(@ModelAttribute DepartmentDTO departmentDTO, @RequestParam("collegeName") String collegeName) {

        departmentService.registerDepartment(departmentDTO);

        return "/Management/ManageDepartRegist";
    }
}
