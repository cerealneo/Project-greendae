package kr.co.greenuniversity.service;

import kr.co.greenuniversity.dto.ProfessorDTO;
import kr.co.greenuniversity.entity.Department;
import kr.co.greenuniversity.entity.Professor;
import kr.co.greenuniversity.repository.DepartmentRepository;
import kr.co.greenuniversity.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ModelMapper modelMapper;
    private final DepartmentRepository departmentRepository;

    public void registerProfessor(Professor professor) {

        professorRepository.save(professor);
    }



}
