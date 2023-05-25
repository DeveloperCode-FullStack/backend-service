package com.sena.backedservice.IRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.backedservice.Dto.IViewDto;
import com.sena.backedservice.Entity.View;

@Repository
public interface IViewRepository extends JpaRepository<View, Long>{

	@Query(value = "SELECT * FROM person", nativeQuery = true)
    Page<IViewDto> getDatatable(Pageable pageable, String search);	
}
