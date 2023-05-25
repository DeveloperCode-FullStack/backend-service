package com.sena.backedservice.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.backedservice.Dto.IRoleDto;
import com.sena.backedservice.Entity.Role;

import com.sena.backedservice.IRepository.IRoleRepository;

import com.sena.backedservice.IService.IRoleService;
import com.sena.backedservice.Utils.GlobalConstants;

@Service
public class RoleService implements IRoleService {

	/**
     * Inyecta una instancia de IRoleRepository en esta clase.
     */
    @Autowired
    public IRoleRepository repository;

    /**
     * Devuelve todas las entidades Role de la base de datos.
     *
     * @return una lista de todas las entidades Role
     */
    @Override
    public List<Role> all() throws Exception{
        return repository.findAll();
    }

    /**
     * Devuelve una entidad Role por su ID.
     *
     * @param id el ID de la entidad Role a recuperar
     * @return un Optional que contiene la entidad Role con el ID especificado, o un Optional vacío si no se encuentra
     * @throws Exception si no se encuentra la entidad Role
     */
    @Override
    public Optional<Role> findById(Long id) throws Exception {
        Optional<Role> op = repository.findById(id);

        if (op.isEmpty()) {
            throw new Exception("No se encontró registro");
        }

        return op;
    }

    /**
     * Guarda una entidad Role en la base de datos.
     *
     * @param role la entidad Role a guardar
     * @return la entidad Role guardada
     */
    @Override
    public Role save(Role role) throws Exception{
        return repository.save(role);
    }

    /**
     * Modifica una entidad Role en la base de datos.
     *
     * @param id     el ID de la entidad Role a modificar
     * @param role la entidad Role modificada
     * @return la entidad Role modificada
     * @throws Exception si no se encuentra la entidad Role
     */
    @Override
    public void update(Long id, Role role) throws Exception {
    	Optional<Role> optionalRole = this.repository.findById(id);

        if (optionalRole.isEmpty()) {
            throw new Exception("No se encontró registro");
        }

        Role roleToUpdate = optionalRole.get();
        BeanUtils.copyProperties(role, roleToUpdate, GlobalConstants.EXCLUDED_FIELDS.toArray(new String[0]));

        this.repository.save(roleToUpdate);
    }

    /**
     * Elimina una entidad Role de la base de datos por su ID.
     *
     * @param id el ID de la entidad Role a eliminar
     */
    @Override
    public void delete(Long id) throws Exception {
        Optional<Role> op = repository.findById(id);

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
     * @return una página de objetos Role que representan los datos de la tabla
     */
    @Override
	public Page<IRoleDto> getDatatable(Pageable pageable, String search) throws Exception{
		return repository.getDatatable(pageable, search);
	}	
}
