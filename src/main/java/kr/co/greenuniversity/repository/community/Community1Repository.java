package kr.co.greenuniversity.repository.community;

import kr.co.greenuniversity.entity.community.Community1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Community1Repository extends JpaRepository<Community1, Integer>, kr.co.greenuniversity.repository.custom.Community1RepositoryCustom {

}