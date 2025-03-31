package kr.co.greenuniversity.repository.custom;

import com.querydsl.core.Tuple;
import kr.co.greenuniversity.dto.PageRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommunityRepositoryCustom {

    public Page<Tuple> selectAllForList(PageRequestDTO pageRequestDTO, Pageable pageable);

    public Page<Tuple> selectAllForSearch(PageRequestDTO pageRequestDTO, Pageable pageable);
}
