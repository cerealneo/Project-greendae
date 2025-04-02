package kr.co.greenuniversity.service.community;

import kr.co.greenuniversity.dto.community.Community2DTO;
import kr.co.greenuniversity.dto.community.Community1DTO;
import kr.co.greenuniversity.entity.community.Community1;
import kr.co.greenuniversity.entity.community.Community2;
import kr.co.greenuniversity.entity.user.User;
import kr.co.greenuniversity.repository.community.Community1Repository;
import kr.co.greenuniversity.repository.community.Community2Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Service
public class CommunityService {

    private final Community1Repository community1Repository;
    private final Community2Repository community2Repository;
    private final ModelMapper modelMapper;

    // 글보기
    public Community1DTO findById1(int no) {
        Optional<Community1> optCommunity = community1Repository.findById(no);

        if (optCommunity.isPresent()) {
            Community1 community = optCommunity.get();
            Community1DTO communityDTO = modelMapper.map(community, Community1DTO.class);
            return communityDTO;
        }
        return null;
    }

    public Community2DTO findById2(int no) {
        Optional<Community2> optCommunity = community2Repository.findById(no);

        if (optCommunity.isPresent()) {
            Community2 community = optCommunity.get();
            Community2DTO communityDTO = modelMapper.map(community, Community2DTO.class);
            return communityDTO;
        }
        return null;
    }


    // 글쓰기
    public int register1(Community1DTO communityDTO) {
        User user = User.builder()
                .id(communityDTO.getWriter())
                .build();

        Community1 community = modelMapper.map(communityDTO, Community1.class);
        community.setUser(user);

        Community1 savedCommunity = community1Repository.save(community);

        return savedCommunity.getNo();
    }

    public int register2(Community2DTO communityDTO) {
        User user = User.builder()
                .id(communityDTO.getWriter())
                .build();

        Community2 community = modelMapper.map(communityDTO, Community2.class);
        community.setUser(user);

        log.info("CommunityDTO: " + communityDTO);

        Community2 savedCommunity = community2Repository.save(community);

        log.info("saved community: " + savedCommunity);

        return savedCommunity.getNo();
    }

    @Transactional
    public void response(int parent) {
        Community2 community = community2Repository.findById(parent)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        community.setStatus("resp");
    }



}