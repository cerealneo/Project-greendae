package kr.co.greenuniversity.service.community1;

import com.querydsl.core.Tuple;
import kr.co.greenuniversity.dto.PageRequestDTO;
import kr.co.greenuniversity.dto.PageResponseDTO;
import kr.co.greenuniversity.dto.community.CommunityDTO1;
import kr.co.greenuniversity.entity.community.Community1;
import kr.co.greenuniversity.entity.user.User;
import kr.co.greenuniversity.repository.community1.CommunityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Service
public class CommunityService {

    private final CommunityRepository communityRepository;
    private final ModelMapper modelMapper;

    public PageResponseDTO findAll(PageRequestDTO pageRequestDTO) {

        Pageable pageable = pageRequestDTO.getPageable("no");

        Page<Tuple> pageCommunity = communityRepository.selectAllForList(pageRequestDTO, pageable);

        List<CommunityDTO1> communityDTOList = pageCommunity.getContent().stream().map(tuple -> {
            Community1 community = tuple.get(0, Community1.class);
            String name = tuple.get(1, String.class);
            CommunityDTO1 communityDTO = modelMapper.map(community, CommunityDTO1.class);
            communityDTO.setName(name);
            return communityDTO;
        }).toList();

        int total = (int) pageCommunity.getTotalElements();

        return PageResponseDTO.<CommunityDTO1>builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(communityDTOList)
                .total(total)
                .build();
    }

    public PageResponseDTO searchAll(PageRequestDTO pageRequestDTO) {

        Pageable pageable = pageRequestDTO.getPageable("no");

        Page<Tuple> pageCommunity = communityRepository.selectAllForSearch(pageRequestDTO, pageable);

        List<CommunityDTO1> communityDTOList = pageCommunity.getContent().stream().map(tuple -> {
            Community1 community = tuple.get(0, Community1.class);
            String name = tuple.get(1, String.class);
            CommunityDTO1 communityDTO = modelMapper.map(community, CommunityDTO1.class);
            communityDTO.setName(name);
            return communityDTO;
        }).toList();

        int total = (int) pageCommunity.getTotalElements();

        return PageResponseDTO.<CommunityDTO1>builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(communityDTOList)
                .total(total)
                .build();
    }

    public CommunityDTO1 findById(int no) {
        Optional<Community1> optCommunity = communityRepository.findById(no);
        log.info("optCommunity: {}", optCommunity);

        if (optCommunity.isPresent()) {
            Community1 community = optCommunity.get();
            CommunityDTO1 communityDTO = modelMapper.map(community, CommunityDTO1.class);
            return communityDTO;
        }
        return null;
    }

    public int register(CommunityDTO1 communityDTO) {

        User user = User.builder()
                .id(communityDTO.getWriter())
                .build();

        Community1 community = modelMapper.map(communityDTO, Community1.class);
        community.setUser(user);

        Community1 savedCommunity = communityRepository.save(community);

        return savedCommunity.getNo();
    }

}