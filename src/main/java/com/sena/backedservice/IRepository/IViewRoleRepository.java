package com.sena.backedservice.IRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.backedservice.Dto.IViewRoleDto;
import com.sena.backedservice.Entity.ViewRole;

@Repository
public interface IViewRoleRepository extends JpaRepository<ViewRole, Long>{

	@Query(value = "SELECT * FROM person", nativeQuery = true)
    Page<IViewRoleDto> getDatatable(Pageable pageable, String search);
}
