package com.sena.backedservice.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.backedservice.Dto.IViewRoleDto;
import com.sena.backedservice.Entity.ViewRole;

import com.sena.backedservice.IRepository.IViewRoleRepository;

import com.sena.backedservice.IService.IViewRoleService;
import com.sena.backedservice.Utils.GlobalConstants;

@Service
public class ViewRoleService implements IViewRoleService {

	/**
     * Inyecta una instancia de IViewRoleRepository en esta clase.
     */
    @Autowired
    public IViewRoleRepository repository;

    /**
     * Devuelve todas las entidades ViewRole de la base de datos.
     *
     * @return una lista de todas las entidades ViewRole
     */
    @Override
    public List<ViewRole> all() throws Exception {
        return repository.findAll();
    }

    /**
     * Devuelve una entidad ViewRole por su ID.
     *
     * @param id el ID de la entidad ViewRole a recuperar
     * @return un Optional que contiene la entidad ViewRole con el ID especificado, o un Optional vacío si no se encuentra
     * @throws Exception si no se encuentra la entidad ViewRole
     */
    @Override
    public Optional<ViewRole> findById(Long id) throws Exception {
        Optional<ViewRole> op = repository.findById(id);

        if (op.isEmpty()) {
            throw new Exception("No se encontró registro");
        }

        return op;
    }

    /**
     * Guarda una entidad ViewRole en la base de datos.
     *
     * @param viewRole la entidad ViewRole a guardar
     * @return la entidad ViewRole guardada
     */
    @Override
    public ViewRole save(ViewRole viewRole) throws Exception{
        return repository.save(viewRole);
    }

    /**
     * Modifica una entidad ViewRole en la base de datos.
     *
     * @param id     el ID de la entidad ViewRole a modificar
     * @param viewRole la entidad ViewRole modificada
     * @return la entidad ViewRole modificada
     * @throws Exception si no se encuentra la entidad ViewRole
     */
    @Override
    public void update(Long id, ViewRole viewRole) throws Exception {
    	Optional<ViewRole> optionalViewRole = this.repository.findById(id);

        if (optionalViewRole.isEmpty()) {
            throw new Exception("No se encontró registro");
        }

        ViewRole viewRoleToUpdate = optionalViewRole.get();
        BeanUtils.copyProperties(viewRole, viewRoleToUpdate, GlobalConstants.EXCLUDED_FIELDS.toArray(new String[0]));

        this.repository.save(viewRoleToUpdate);
    }

    /**
     * Elimina una entidad ViewRole de la base de datos por su ID.
     *
     * @param id el ID de la entidad ViewRole a eliminar
     */
    @Override
    public void delete(Long id) throws Exception {
        Optional<ViewRole> op = repository.findById(id);

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
     * @return una página de objetos ViewRole que representan los datos de la tabla
     */
    @Override
	public Page<IViewRoleDto> getDatatable(Pageable pageable, String search) throws Exception{
		return repository.getDatatable(pageable, search);
	}	
}
