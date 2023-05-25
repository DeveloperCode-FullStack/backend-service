package com.sena.backedservice.IService;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.backedservice.Dto.IUserRoleDto;
import com.sena.backedservice.Entity.UserRole;

public interface IUserRoleService {
	
    /**
     * Recupera todos los roles de usuario existentes.
     *
     * @return una lista de objetos UserRole que representan todos los roles de usuario existentes
     */
    public List<UserRole> all() throws Exception;

    /**
     * Recupera un rol de usuario por su ID.
     *
     * @param id el ID del rol de usuario a recuperar
     * @return el objeto UserRole correspondiente al ID proporcionado, o un Optional vacío si no se encuentra ningún rol de usuario con el ID proporcionado
     */
    public Optional<UserRole> findById(Long id) throws Exception;

    /**
     * Guarda un rol de usuario en la base de datos.
     *
     * @param userRole el objeto UserRole a guardar
     * @return el objeto UserRole guardado en la base de datos
     */
    public UserRole save(UserRole userRole) throws Exception;

    /**
     * Actualiza un rol de usuario existente en la base de datos.
     *
     * @param id el ID del rol de usuario a actualizar
     * @param userRole el objeto UserRole con los datos actualizados
     * @return el objeto UserRole actualizado
     */
    public void update(Long id, UserRole userRole) throws Exception;

    /**
     * Elimina un rol de usuario existente de la base de datos.
     *
     * @param id el ID del rol de usuario a eliminar
     */
    public void delete(Long id) throws Exception;

    /**
     * Recupera una página de roles de usuario que coincidan con una cadena de búsqueda.
     *
     * @param pageable información sobre la paginación
     * @param search la cadena de búsqueda para filtrar los roles de usuario
     * @return una página de objetos UserRole que representan los roles de usuario encontrados
     */
    public Page<IUserRoleDto> getDatatable(Pageable pageable, String search) throws Exception;
}
