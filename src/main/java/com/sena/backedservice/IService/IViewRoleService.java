package com.sena.backedservice.IService;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.backedservice.Dto.IViewRoleDto;
import com.sena.backedservice.Entity.ViewRole;

public interface IViewRoleService {
	
    /**
     * Recupera todos los roles de vista existentes.
     *
     * @return una lista de objetos ViewRole que representan todos los roles de vista existentes
     */
    public List<ViewRole> all() throws Exception;

    /**
     * Recupera un rol de vista por su ID.
     *
     * @param id el ID del rol de vista a recuperar
     * @return el objeto ViewRole correspondiente al ID proporcionado, o un Optional vacío si no se encuentra ningún rol de vista con el ID proporcionado
     */
    public Optional<ViewRole> findById(Long id) throws Exception;

    /**
     * Guarda un rol de vista en la base de datos.
     *
     * @param viewRole el objeto ViewRole a guardar
     * @return el objeto ViewRole guardado en la base de datos
     */
    public ViewRole save(ViewRole viewRole) throws Exception;

    /**
     * Actualiza un rol de vista existente en la base de datos.
     *
     * @param id el ID del rol de vista a actualizar
     * @param viewRole el objeto ViewRole con los datos actualizados
     * @return el objeto ViewRole actualizado
     */
    public void update(Long id, ViewRole viewRole) throws Exception;

    /**
     * Elimina un rol de vista existente de la base de datos.
     *
     * @param id el ID del rol de vista a eliminar
     */
    public void delete(Long id) throws Exception;

    /**
     * Recupera una página de roles de vista que coincidan con una cadena de búsqueda.
     *
     * @param pageable información sobre la paginación
     * @param search la cadena de búsqueda para filtrar los roles de vista
     * @return una página de objetos ViewRole que representan los roles de vista encontrados
     */
    public Page<IViewRoleDto> getDatatable(Pageable pageable, String search) throws Exception; 
}
