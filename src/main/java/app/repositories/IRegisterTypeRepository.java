package app.repositories;

import app.entities.RegisterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegisterTypeRepository extends JpaRepository<RegisterType, Long> {
}
