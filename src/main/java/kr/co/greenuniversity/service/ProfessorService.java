package kr.co.greenuniversity.service;

import kr.co.greenuniversity.dto.ProfessorDTO;
import kr.co.greenuniversity.entity.Professor;
import kr.co.greenuniversity.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProfessorService {

   // private final ProfessorRepository professorRepository;
   // private final ModelMapper modelMapper;

   // public void registerProfessor(ProfessorDTO professorDTO) {

   //     Professor professor = modelMapper.map(professorDTO, Professor.class);
   //     log.info("Registering professor {}", professor);
   //     professorRepository.save(professor);
   // }
}
