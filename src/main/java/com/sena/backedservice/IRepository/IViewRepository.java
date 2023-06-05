package com.sena.backedservice.IRepository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sena.backedservice.Dto.IViewDto;
import com.sena.backedservice.Entity.View;

public interface IViewRepository extends JpaRepository<View, Long>{

	@Query(value = "SELECT "
				+ " 	v.code, "
				+ " 	v.route, "
				+ " 	v.icon, "
				+ " 	v.label, "
				+ " 	v.state, "
				+ " 	m.route as module "
				+ " FROM "
				+ " 	view v"
				+ " INNER JOIN module m ON m.id = v.module_id"
				+ " WHERE "
				+ "     v.state = true "
				+ " AND	m.state = true ", nativeQuery = true)
	Page<IViewDto> getDatatable(Pageable pageable, String search);
	
	@Query(value = "SELECT "
		+ " 	count(code) as quantity "
		+ " FROM "
		+ " 	view "
		+ " WHERE code = :code "
		+ " OR route = :route ", nativeQuery = true)
	Optional<IViewDto> getValidate(String code, String route);
}
