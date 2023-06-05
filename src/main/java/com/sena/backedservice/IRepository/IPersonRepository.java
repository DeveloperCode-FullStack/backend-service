package com.sena.backedservice.IRepository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sena.backedservice.Dto.IPersonDto;
import com.sena.backedservice.Entity.Person;

public interface IPersonRepository extends JpaRepository<Person, Long>{
	
	@Query(value = "SELECT * FROM person", nativeQuery = true)
    Page<IPersonDto> getDatatable(Pageable pageable, String search);
	
	@Query(value = "SELECT "
			+ " 	count(id) as quantity "
			+ " FROM "
			+ " 	person "
			+ " WHERE document = :document "
			+ " OR mail = :mail ", nativeQuery = true)
    Optional<IPersonDto> getValidate(String document, String mail);
}
