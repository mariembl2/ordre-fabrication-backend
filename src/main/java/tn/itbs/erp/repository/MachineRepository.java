package tn.itbs.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.itbs.erp.model.Machine;

public interface MachineRepository extends JpaRepository<Machine, Integer> {
	
}
