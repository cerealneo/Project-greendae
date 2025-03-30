package kr.co.greenuniversity.repository;

import kr.co.greenuniversity.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    List<Department> findByCollege_CollegeName(String collegeName);

}
