package com.sena.backedservice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.backedservice.Dto.IModuleDto;
import com.sena.backedservice.Entity.Module;
import com.sena.backedservice.IRepository.IModuleRepository;
import com.sena.backedservice.IService.IModuleService;
import com.sena.backedservice.Utils.GlobalConstants;

/**
 * Esta clase proporciona la implementación para la interfaz IModuleService.
 * Está anotada con @Service para indicar que es un componente de servicio de Spring.
 */
@Service
public class ModuleService implements IModuleService {

    /**
     * Inyecta una instancia de IModuleRepository en esta clase.
     */
    @Autowired
    public IModuleRepository repository;

    /**
     * Devuelve todas las entidades Module de la base de datos.
     *
     * @return una lista de todas las entidades Module
     */
    @Override
    public List<Module> all() throws Exception {
        return repository.findAll();
    }

    /**
     * Devuelve una entidad Module por su ID.
     *
     * @param id el ID de la entidad Module a recuperar
     * @return un Optional que contiene la entidad Module con el ID especificado, o un Optional vacío si no se encuentra
     * @throws Exception si no se encuentra la entidad Module
     */
    @Override
    public Optional<Module> findById(Long id) throws Exception {
        Optional<Module> op = repository.findById(id);

        if (op.isEmpty()) {
            throw new Exception("No se encontró registro");
        }

        return op;
    }

    /**
     * Guarda una entidad Module en la base de datos.
     *
     * @param module la entidad Module a guardar
     * @return la entidad Module guardada
     */
    @Override
    public Module save(Module module) throws Exception {
        return repository.save(module);
    }

    /**
     * Modifica una entidad Module en la base de datos.
     *
     * @param id     el ID de la entidad Module a modificar
     * @param module la entidad Module modificada
     * @return la entidad Module modificada
     * @throws Exception si no se encuentra la entidad Module
     */
    @Override
    public void update(Long id, Module module) throws Exception {
    	Optional<Module> optionalModule = this.repository.findById(id);

        if (optionalModule.isEmpty()) {
            throw new Exception("No se encontró registro");
        }

        Module moduleToUpdate = optionalModule.get();
        BeanUtils.copyProperties(module, moduleToUpdate, GlobalConstants.EXCLUDED_FIELDS.toArray(new String[0]));

        this.repository.save(moduleToUpdate);
    }

    /**
     * Elimina una entidad Module de la base de datos por su ID.
     *
     * @param id el ID de la entidad Module a eliminar
     */
    @Override
    public void delete(Long id) throws Exception {
        Optional<Module> op = repository.findById(id);

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
     * @return una página de objetos Module que representan los datos de la tabla
     */
    @Override
	public Page<IModuleDto> getDatatable(Pageable pageable, String search) throws Exception{
		return repository.getDatatable(pageable, search);
	}
}
