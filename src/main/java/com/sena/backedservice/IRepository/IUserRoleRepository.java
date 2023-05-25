package com.sena.backedservice.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.backedservice.Entity.UserRole;

@Repository
public interface IUserRoleRepository extends JpaRepository<UserRole, Long>{

}
