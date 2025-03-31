package kr.co.greenuniversity.service;

import kr.co.greenuniversity.dto.StudentDTO;
import kr.co.greenuniversity.entity.Student;
import kr.co.greenuniversity.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public void registerStudent(StudentDTO studentDTO) {

        Student student = modelMapper.map(studentDTO, Student.class);
        log.info("Registering student {}", student);
        studentRepository.save(student);
    }


}
