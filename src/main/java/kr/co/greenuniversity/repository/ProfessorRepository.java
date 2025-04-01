package kr.co.greenuniversity.repository;

import kr.co.greenuniversity.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

   // List<Professor> findByDepartment_nameAndCollege_name(String departmentName, String collegeName);

   // List<Professor> fintByDepartment_name(String departmentName);

}
