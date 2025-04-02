package kr.co.greenuniversity.repository;

import kr.co.greenuniversity.entity.Department;
import kr.co.greenuniversity.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    Optional<Student> findStudentById(String id);

    List<Student> findByIdStartingWith(String idPrefix);

    long countByIdStartingWith(String prefix);

    int countByDepartment(Department department);
}
