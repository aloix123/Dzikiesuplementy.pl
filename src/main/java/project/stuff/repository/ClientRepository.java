package project.stuff.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.stuff.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
