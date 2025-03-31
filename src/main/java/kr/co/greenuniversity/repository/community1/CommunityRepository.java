package kr.co.greenuniversity.repository.community1;

import kr.co.greenuniversity.entity.community.Community;
import kr.co.greenuniversity.repository.custom.CommunityRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommunityRepository extends JpaRepository<Community, Integer>, CommunityRepositoryCustom {

}
