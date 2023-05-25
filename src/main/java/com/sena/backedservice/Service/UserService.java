package com.sena.backedservice.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.backedservice.Dto.ILoginDto;
import com.sena.backedservice.Dto.IPermissionDto;
import com.sena.backedservice.Dto.IUserDto;
import com.sena.backedservice.Entity.User;

import com.sena.backedservice.IRepository.IUserRepository;

import com.sena.backedservice.IService.IUserService;
import com.sena.backedservice.Utils.GlobalConstants;

@Service
public class UserService implements IUserService {

	/**
     * Inyecta una instancia de IUserRepository en esta clase.
     */
    @Autowired
    public IUserRepository repository;

    /**
     * Devuelve todas las entidades User de la base de datos.
     *
     * @return una lista de todas las entidades User
     */
    @Override
    public List<User> all() throws Exception {
        return repository.findAll();
    }

    /**
     * Devuelve una entidad User por su ID.
     *
     * @param id el ID de la entidad User a recuperar
     * @return un Optional que contiene la entidad User con el ID especificado, o un Optional vacío si no se encuentra
     * @throws Exception si no se encuentra la entidad User
     */
    @Override
    public Optional<User> findById(Long id) throws Exception {
        Optional<User> op = repository.findById(id);

        if (op.isEmpty()) {
            throw new Exception("No se encontró registro");
        }

        return op;
    }

    /**
     * Guarda una entidad User en la base de datos.
     *
     * @param user la entidad User a guardar
     * @return la entidad User guardada
     */
    @Override
    public User save(User user) throws Exception{
        return repository.save(user);
    }

    /**
     * Modifica una entidad User en la base de datos.
     *
     * @param id     el ID de la entidad User a modificar
     * @param user la entidad User modificada
     * @return la entidad User modificada
     * @throws Exception si no se encuentra la entidad User
     */
    @Override
    public void update(Long id, User user) throws Exception {
    	Optional<User> optionalUser = this.repository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new Exception("No se encontró registro");
        }

        User userToUpdate = optionalUser.get();
        BeanUtils.copyProperties(user, userToUpdate, GlobalConstants.EXCLUDED_FIELDS.toArray(new String[0]));

        this.repository.save(userToUpdate);
    }

    /**
     * Elimina una entidad User de la base de datos por su ID.
     *
     * @param id el ID de la entidad User a eliminar
     */
    @Override
    public void delete(Long id) throws Exception {
        Optional<User> op = repository.findById(id);

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
     * @return una página de objetos User que representan los datos de la tabla
     */
    @Override
	public Page<IUserDto> getDatatable(Pageable pageable, String search) throws Exception{
		return repository.getDatatable(pageable, search);
	}

    /**
     * Obtiene los permisos de un usuario y contraseña especificados.
     *
     * @param user     el nombre de usuario
     * @param password la contraseña del usuario
     * @return una lista de objetos IPermissionDto que representan los permisos del usuario
     * @throws Exception si ocurre un error al obtener los permisos
     */
    @Override
    public List<IPermissionDto> getPermission(String user, String password) throws Exception {
        return repository.getPermission(user, password);
    }

    /**
     * Obtiene los detalles de inicio de sesión de un usuario y contraseña especificados.
     *
     * @param user     el nombre de usuario
     * @param password la contraseña del usuario
     * @return un Optional que contiene un objeto ILoginDto que representa los detalles de inicio de sesión del usuario,
     *         o un Optional vacío si no se encontró el usuario o la contraseña no coincide
     * @throws Exception si ocurre un error al obtener los detalles de inicio de sesión
     */
    @Override
    public Optional<ILoginDto> getLogin(String user, String password) throws Exception {
        return repository.getLogin(user, password);
    }    
}
