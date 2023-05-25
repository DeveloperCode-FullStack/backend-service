package com.sena.backedservice.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.backedservice.Dto.IUserRoleDto;
import com.sena.backedservice.Entity.UserRole;

import com.sena.backedservice.IRepository.IUserRoleRepository;

import com.sena.backedservice.IService.IUserRoleService;
import com.sena.backedservice.Utils.GlobalConstants;

@Service
public class UserRoleService implements IUserRoleService {

	/**
     * Inyecta una instancia de IUserRoleRepository en esta clase.
     */
    @Autowired
    public IUserRoleRepository repository;

    /**
     * Devuelve todas las entidades UserRole de la base de datos.
     *
     * @return una lista de todas las entidades UserRole
     */
    @Override
    public List<UserRole> all() throws Exception {
        return repository.findAll();
    }

    /**
     * Devuelve una entidad UserRole por su ID.
     *
     * @param id el ID de la entidad UserRole a recuperar
     * @return un Optional que contiene la entidad UserRole con el ID especificado, o un Optional vacío si no se encuentra
     * @throws Exception si no se encuentra la entidad UserRole
     */
    @Override
    public Optional<UserRole> findById(Long id) throws Exception {
        Optional<UserRole> op = repository.findById(id);

        if (op.isEmpty()) {
            throw new Exception("No se encontró registro");
        }

        return op;
    }

    /**
     * Guarda una entidad UserRole en la base de datos.
     *
     * @param userRole la entidad UserRole a guardar
     * @return la entidad UserRole guardada
     */
    @Override
    public UserRole save(UserRole userRole) throws Exception{
        return repository.save(userRole);
    }

    /**
     * Modifica una entidad UserRole en la base de datos.
     *
     * @param id     el ID de la entidad UserRole a modificar
     * @param userRole la entidad UserRole modificada
     * @return la entidad UserRole modificada
     * @throws Exception si no se encuentra la entidad UserRole
     */
    @Override
    public void update(Long id, UserRole userRole) throws Exception {
    	Optional<UserRole> optionalUserRole = this.repository.findById(id);

        if (optionalUserRole.isEmpty()) {
            throw new Exception("No se encontró registro");
        }

        UserRole userRoleToUpdate = optionalUserRole.get();
        BeanUtils.copyProperties(userRole, userRoleToUpdate, GlobalConstants.EXCLUDED_FIELDS.toArray(new String[0]));

        this.repository.save(userRoleToUpdate);
    }

    /**
     * Elimina una entidad UserRole de la base de datos por su ID.
     *
     * @param id el ID de la entidad UserRole a eliminar
     */
    @Override
    public void delete(Long id) throws Exception {
        Optional<UserRole> op = repository.findById(id);

        if (op.isEmpty()) {
            throw new Exception("No se encontró registro");
        }

        repository.deleteById(id);
    }
	

    /**
     * Recupera una página de datos de la tabla que cumpla con los criterios de paginación y búsqueda.
     *
     * @param pageable información sobre la paginación
     * @param search   la cadena de búsqueda para filtrar los datos de la tabla
     * @return una página de objetos UserRole que representan los datos de la tabla
     */
    @Override
	public Page<IUserRoleDto> getDatatable(Pageable pageable, String search) throws Exception{
		return repository.getDatatable(pageable, search);
	}	
}
