package com.sena.backedservice.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.backedservice.Entity.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long>{

}
