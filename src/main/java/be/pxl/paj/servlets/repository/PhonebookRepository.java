package be.pxl.paj.servlets.repository;

import be.pxl.paj.servlets.domain.Phonebook;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface PhonebookRepository extends JpaRepository<Phonebook, Long>{
}
