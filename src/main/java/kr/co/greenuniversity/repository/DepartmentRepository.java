package kr.co.greenuniversity.repository;

import kr.co.greenuniversity.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    List<Department> findByCollege_CollegeName(String collegeName);

    @Query("SELECT MAX(d.no) FROM Department d")
    Optional<Integer> findMaxNo();

    String departmentName(String departmentName);

    Optional<Department> findByDepartmentName(String departmentName);
    //Optional<Department> findByCollege_CollegeNameAndDepartmentName(String collegeName, String departmentName);
}