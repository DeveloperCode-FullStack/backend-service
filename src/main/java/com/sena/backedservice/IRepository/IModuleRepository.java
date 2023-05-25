package com.sena.backedservice.IRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.backedservice.Dto.IModuleDto;
import com.sena.backedservice.Entity.Module;

@Repository
public interface IModuleRepository extends JpaRepository<Module, Long>  {

	
	@Query(value = "SELECT * FROM person", nativeQuery = true)
    Page<IModuleDto> getDatatable(Pageable pageable, String search);
}
