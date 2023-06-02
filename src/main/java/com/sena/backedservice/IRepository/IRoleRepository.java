package com.sena.backedservice.IRepository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sena.backedservice.Dto.IRoleDto;
import com.sena.backedservice.Entity.Role;

public interface IRoleRepository extends JpaRepository<Role, Long>{

	@Query(value = "SELECT * FROM person", nativeQuery = true)
    Page<IRoleDto> getDatatable(Pageable pageable, String search);
	
	@Query(value = "SELECT "
			+ " 	count(code) as quantity "
			+ " FROM "
			+ " 	role "
			+ " WHERE code = :code "
			+ " OR description = :description ", nativeQuery = true)
		Optional<IRoleDto> getValidate(String code, String description);
}
