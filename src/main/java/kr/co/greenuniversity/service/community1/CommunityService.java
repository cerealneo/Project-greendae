package kr.co.greenuniversity.service.community1;

import com.querydsl.core.Tuple;
import kr.co.greenuniversity.dto.PageRequestDTO;
import kr.co.greenuniversity.dto.PageResponseDTO;
import kr.co.greenuniversity.dto.community.CommunityDTO;
import kr.co.greenuniversity.entity.community.Community;
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

        List<CommunityDTO> communityDTOList = pageCommunity.getContent().stream().map(tuple -> {
            Community community = tuple.get(0, Community.class);
            String name = tuple.get(1, String.class);
            CommunityDTO communityDTO = modelMapper.map(community, CommunityDTO.class);
            communityDTO.setName(name);
            return communityDTO;
        }).toList();

        int total = (int) pageCommunity.getTotalElements();

        return PageResponseDTO.<CommunityDTO>builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(communityDTOList)
                .total(total)
                .build();
    }

    public PageResponseDTO searchAll(PageRequestDTO pageRequestDTO) {

        Pageable pageable = pageRequestDTO.getPageable("no");

        Page<Tuple> pageCommunity = communityRepository.selectAllForSearch(pageRequestDTO, pageable);

        List<CommunityDTO> communityDTOList = pageCommunity.getContent().stream().map(tuple -> {
            Community community = tuple.get(0, Community.class);
            String name = tuple.get(1, String.class);
            CommunityDTO communityDTO = modelMapper.map(community, CommunityDTO.class);
            communityDTO.setName(name);
            return communityDTO;
        }).toList();

        int total = (int) pageCommunity.getTotalElements();

        return PageResponseDTO.<CommunityDTO>builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(communityDTOList)
                .total(total)
                .build();
    }

    public CommunityDTO findById(int no) {
        Optional<Community> optCommunity = communityRepository.findById(no);

        if (optCommunity.isPresent()) {
            Community community = optCommunity.get();
            CommunityDTO communityDTO = modelMapper.map(community, CommunityDTO.class);
            return communityDTO;
        }
        return null;
    }


}
