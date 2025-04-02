package kr.co.greenuniversity.service;

import kr.co.greenuniversity.dto.CollegeDTO;
import kr.co.greenuniversity.dto.LectureDTO;
import kr.co.greenuniversity.entity.College;
import kr.co.greenuniversity.entity.Department;
import kr.co.greenuniversity.entity.Lecture;
import kr.co.greenuniversity.entity.Professor;
import kr.co.greenuniversity.repository.CollegeRepository;
import kr.co.greenuniversity.repository.DepartmentRepository;
import kr.co.greenuniversity.repository.LectureRepository;
import kr.co.greenuniversity.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LectureService {

    private final ProfessorRepository professorRepository;
    private final ModelMapper modelMapper;
    private final DepartmentRepository departmentRepository;




}
