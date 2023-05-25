package com.sena.backedservice.IService;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.backedservice.Dto.IRoleDto;
import com.sena.backedservice.Entity.Role;

public interface IRoleService {
	
    /**
     * Recupera todos los roles existentes.
     *
     * @return una lista de objetos Role que representan todos los roles existentes
     */
    public List<Role> all() throws Exception;

    /**
     * Recupera un rol por su ID.
     *
     * @param id el ID del rol a recuperar
     * @return el objeto Role correspondiente al ID proporcionado, o un Optional vacío si no se encuentra ningún rol con el ID proporcionado
     */
    public Optional<Role> findById(Long id) throws Exception;

    /**
     * Guarda un rol en la base de datos.
     *
     * @param role el objeto Role a guardar
     * @return el objeto Role guardado en la base de datos
     */
    public Role save(Role role) throws Exception;

    /**
     * Actualiza un rol existente en la base de datos.
     *
     * @param id el ID del rol a actualizar
     * @param role el objeto Role con los datos actualizados
     * @return el objeto Role actualizado
     */
    public void update(Long id, Role role) throws Exception;

    /**
     * Elimina un rol existente de la base de datos.
     *
     * @param id el ID del rol a eliminar
     */
    public void delete(Long id) throws Exception;

    /**
     * Recupera una página de roles que coincidan con una cadena de búsqueda.
     *
     * @param pageable información sobre la paginación
     * @param search la cadena de búsqueda para filtrar los roles
     * @return una página de objetos Role que representan los roles encontrados
     */
    public Page<IRoleDto> getDatatable(Pageable pageable, String search) throws Exception;
}