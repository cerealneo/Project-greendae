package kr.co.greenuniversity.repository;

import kr.co.greenuniversity.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College, String> {
}
