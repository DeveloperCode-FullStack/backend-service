package com.sena.backedservice.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.backedservice.Entity.Module;

@Repository
public interface IModuleRepository extends JpaRepository<Module, Long>  {

}
