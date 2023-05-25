package com.sena.backedservice.IService;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.backedservice.Dto.ILoginDto;
import com.sena.backedservice.Dto.IPermissionDto;
import com.sena.backedservice.Dto.IUserDto;
import com.sena.backedservice.Entity.User;

public interface IUserService {
	
    /**
     * Recupera todos los usuarios existentes.
     *
     * @return una lista de objetos User que representan todos los usuarios existentes
     */
    public List<User> all() throws Exception;

    /**
     * Recupera un usuario por su ID.
     *
     * @param id el ID del usuario a recuperar
     * @return el objeto User correspondiente al ID proporcionado, o un Optional vacío si no se encuentra ningún usuario con el ID proporcionado
     */
    public Optional<User> findById(Long id) throws Exception;

    /**
     * Guarda un usuario en la base de datos.
     *
     * @param user el objeto User a guardar
     * @return el objeto User guardado en la base de datos
     */
    public User save(User user) throws Exception;

    /**
     * Actualiza un usuario existente en la base de datos.
     *
     * @param id el ID del usuario a actualizar
     * @param user el objeto User con los datos actualizados
     * @return el objeto User actualizado
     */
    public void update(Long id, User user) throws Exception;

    /**
     * Elimina un usuario existente de la base de datos.
     *
     * @param id el ID del usuario a eliminar
     */
    public void delete(Long id) throws Exception;

    /**
     * Recupera los permisos de un usuario específico.
     *
     * @param user el nombre de usuario
     * @param password la contraseña del usuario
     * @return una lista de objetos IPermissionDto que representan los permisos del usuario
     */
    public List<IPermissionDto> getPermission(String user, String password) throws Exception;

    /**
     * Recupera los datos de inicio de sesión de un usuario específico.
     *
     * @param user el nombre de usuario
     * @param password la contraseña del usuario
     * @return el objeto ILoginDto que representa los datos de inicio de sesión del usuario, o un Optional vacío si no se encuentra ningún usuario con las credenciales proporcionadas
     */
    public Optional<ILoginDto> getLogin(String user, String password) throws Exception;

    /**
     * Recupera una página de usuarios que coincidan con una cadena de búsqueda.
     *
     * @param pageable información sobre la paginación
     * @param search la cadena de búsqueda para filtrar los usuarios
     * @return una página de objetos User que representan los usuarios encontrados
     */
    public Page<IUserDto> getDatatable(Pageable pageable, String search) throws Exception;
}
