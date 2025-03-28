package kr.co.greenuniversity.repository.user;

import kr.co.greenuniversity.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
