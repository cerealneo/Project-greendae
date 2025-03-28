package kr.co.greenuniversity.service;

import kr.co.greenuniversity.dto.DepartmentDTO;
import kr.co.greenuniversity.entity.College;
import kr.co.greenuniversity.entity.Department;
import kr.co.greenuniversity.repository.CollegeRepository;
import kr.co.greenuniversity.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final CollegeRepository collegeRepository;
    private final ModelMapper modelMapper;

    public void registerDepartment(DepartmentDTO departmentDTO) {

        Department department = modelMapper.map(departmentDTO, Department.class);
        log.info("Registering department {}", department);

        College college = collegeRepository.findByCollegeName(departmentDTO.getCollegeName())
                        .orElseThrow(() -> new IllegalArgumentException("대학명이 존재하지 않습니다."));

        department.setCollege(college);
        departmentRepository.save(department);
        log.info("Department {}", department);
    }

    public List<Department> getDepartmentsByCollegeName(String collegeName){

        return departmentRepository.findByCollege_CollegeName(collegeName);

    }
}
