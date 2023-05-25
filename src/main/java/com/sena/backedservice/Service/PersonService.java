package com.sena.backedservice.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.backedservice.Dto.IPersonDto;
import com.sena.backedservice.Entity.Person;

import com.sena.backedservice.IRepository.IPersonRepository;

import com.sena.backedservice.IService.IPersonService;
import com.sena.backedservice.Utils.GlobalConstants;

@Service
public class PersonService implements IPersonService {

	/**
     * Inyecta una instancia de IPersonRepository en esta clase.
     */
    @Autowired
    public IPersonRepository repository;

    /**
     * Devuelve todas las entidades Person de la base de datos.
     *
     * @return una lista de todas las entidades Person
     */
    @Override
    public List<Person> all() throws Exception {
        return repository.findAll();
    }

    /**
     * Devuelve una entidad Person por su ID.
     *
     * @param id el ID de la entidad Person a recuperar
     * @return un Optional que contiene la entidad Person con el ID especificado, o un Optional vacío si no se encuentra
     * @throws Exception si no se encuentra la entidad Person
     */
    @Override
    public Optional<Person> findById(Long id) throws Exception {
        Optional<Person> op = repository.findById(id);

        if (op.isEmpty()) {
            throw new Exception("No se encontró registro");
        }

        return op;
    }

    /**
     * Guarda una entidad Person en la base de datos.
     *
     * @param person la entidad Person a guardar
     * @return la entidad Person guardada
     */
    @Override
    public Person save(Person person) throws Exception{
        return repository.save(person);
    }

    /**
     * Modifica una entidad Person en la base de datos.
     *
     * @param id     el ID de la entidad Person a modificar
     * @param person la entidad Person modificada
     * @return la entidad Person modificada
     * @throws Exception si no se encuentra la entidad Person
     */
    @Override
    public void update(Long id, Person person) throws Exception {
    	Optional<Person> optionalPerson = this.repository.findById(id);

        if (optionalPerson.isEmpty()) {
            throw new Exception("No se encontró registro");
        }

        Person personToUpdate = optionalPerson.get();
        BeanUtils.copyProperties(person, personToUpdate, GlobalConstants.EXCLUDED_FIELDS.toArray(new String[0]));

        this.repository.save(personToUpdate);
    }

    /**
     * Elimina una entidad Person de la base de datos por su ID.
     *
     * @param id el ID de la entidad Person a eliminar
     */
    @Override
    public void delete(Long id) throws Exception {
        Optional<Person> op = repository.findById(id);

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
     * @return una página de objetos Person que representan los datos de la tabla
     */
    @Override
	public Page<IPersonDto> getDatatable(Pageable pageable, String search) throws Exception{
		return repository.getDatatable(pageable, search);
	}	
}
