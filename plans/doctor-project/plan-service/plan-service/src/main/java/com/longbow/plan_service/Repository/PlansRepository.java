package com.longbow.plan_service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.longbow.plan_service.Entity.Plans;

public interface PlansRepository extends JpaRepository<Plans, Integer>{

	List<Plans> findByIsActive(boolean isActive);
	

  
	

}
