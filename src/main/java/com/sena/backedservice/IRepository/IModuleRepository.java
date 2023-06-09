package com.sena.backedservice.IRepository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sena.backedservice.Dto.IModuleDto;
import com.sena.backedservice.Entity.Module;

public interface IModuleRepository extends JpaRepository<Module, Long>  {

	
	@Query(value = "SELECT "
					+ " code, "
					+ " route, "
					+ " label "
					+ "FROM "
					+ "	module "
					+ "WHERE state = true", nativeQuery = true)
    Page<IModuleDto> getDatatable(Pageable pageable, String search);
	
	@Query(value = "SELECT "
			+ " 	count(code) as quantity "
			+ " FROM "
			+ " 	module "
			+ " WHERE code = :code "
			+ " OR route = :route ", nativeQuery = true)
    Optional<IModuleDto> getValidate(String code, String route);
}
