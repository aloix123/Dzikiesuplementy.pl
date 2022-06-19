package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.User;

public interface UserREpository extends JpaRepository<User,Long> {
}
