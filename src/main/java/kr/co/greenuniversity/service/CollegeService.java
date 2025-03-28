package kr.co.greenuniversity.service;

import kr.co.greenuniversity.dto.CollegeDTO;
import kr.co.greenuniversity.dto.UserDTO;
import kr.co.greenuniversity.entity.College;
import kr.co.greenuniversity.repository.CollegeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CollegeService {

    private final CollegeRepository collegeRepository;
    private final ModelMapper modelMapper;

    public void registerCollege(CollegeDTO collegeDTO){

        College college = modelMapper.map(collegeDTO, College.class);
        log.info("college : {}", college);

        collegeRepository.save(college);

    }
}
