package kr.co.greenuniversity.repository;

import kr.co.greenuniversity.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CollegeRepository extends JpaRepository<College, Integer> {
    Optional<College> findByCollegeName(String collegeName);
}
