package com.sena.backedservice.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.backedservice.Entity.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long>{

}
