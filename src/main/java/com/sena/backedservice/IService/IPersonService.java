package com.sena.backedservice.IService;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.backedservice.Dto.IPersonDto;
import com.sena.backedservice.Entity.Person;

public interface IPersonService {
	
    /**
     * Recupera todos las personas existentes.
     *
     * @return una lista de objetos Person que representan todas las personas existentes
     */
    public List<Person> all() throws Exception;

    /**
     * Recupera una persona por su ID.
     *
     * @param id el ID de la persona a recuperar
     * @return el objeto Person correspondiente al ID proporcionado, o un Optional vacío si no se encuentra ninguna persona con el ID proporcionado
     */
    public Optional<Person> findById(Long id) throws Exception;

    /**
     * Guarda una persona en la base de datos.
     *
     * @param person el objeto Person a guardar
     * @return el objeto Person guardado en la base de datos
     */
    public Person save(Person person) throws Exception;

    /**
     * Actualiza una persona existente en la base de datos.
     *
     * @param id el ID de la persona a actualizar
     * @param person el objeto Person con los datos actualizados
     * @return el objeto Person actualizado
     */
    public void update(Long id, Person person) throws Exception;

    /**
     * Elimina una persona existente de la base de datos.
     *
     * @param id el ID de la persona a eliminar
     */
    public void delete(Long id) throws Exception;

    /**
     * Recupera una página de personas que coincidan con una cadena de búsqueda.
     *
     * @param pageable información sobre la paginación
     * @param search la cadena de búsqueda para filtrar las personas
     * @return una página de objetos Person que representan las personas encontradas
     */
    public Page<IPersonDto> getDatatable(Pageable pageable, String search) throws Exception;
}
