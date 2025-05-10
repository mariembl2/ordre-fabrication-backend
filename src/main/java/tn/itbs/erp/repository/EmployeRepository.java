package tn.itbs.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.itbs.erp.model.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {
}
