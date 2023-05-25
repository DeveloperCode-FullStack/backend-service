package com.sena.backedservice.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.backedservice.Dto.IViewDto;
import com.sena.backedservice.Entity.View;

import com.sena.backedservice.IRepository.IViewRepository;

import com.sena.backedservice.IService.IViewService;
import com.sena.backedservice.Utils.GlobalConstants;

@Service
public class ViewService implements IViewService {

	/**
     * Inyecta una instancia de IViewRepository en esta clase.
     */
    @Autowired
    public IViewRepository repository;

    /**
     * Devuelve todas las entidades View de la base de datos.
     *
     * @return una lista de todas las entidades View
     */
    @Override
    public List<View> all() throws Exception {
        return repository.findAll();
    }

    /**
     * Devuelve una entidad View por su ID.
     *
     * @param id el ID de la entidad View a recuperar
     * @return un Optional que contiene la entidad View con el ID especificado, o un Optional vacío si no se encuentra
     * @throws Exception si no se encuentra la entidad View
     */
    @Override
    public Optional<View> findById(Long id) throws Exception {
        Optional<View> op = repository.findById(id);

        if (op.isEmpty()) {
            throw new Exception("No se encontró registro");
        }

        return op;
    }

    /**
     * Guarda una entidad View en la base de datos.
     *
     * @param view la entidad View a guardar
     * @return la entidad View guardada
     */
    @Override
    public View save(View view) throws Exception{
        return repository.save(view);
    }

    /**
     * Modifica una entidad View en la base de datos.
     *
     * @param id     el ID de la entidad View a modificar
     * @param view la entidad View modificada
     * @return la entidad View modificada
     * @throws Exception si no se encuentra la entidad View
     */
    @Override
    public void update(Long id, View view) throws Exception {
    	Optional<View> optionalView = this.repository.findById(id);

        if (optionalView.isEmpty()) {
            throw new Exception("No se encontró registro");
        }

        View viewToUpdate = optionalView.get();
        BeanUtils.copyProperties(view, viewToUpdate, GlobalConstants.EXCLUDED_FIELDS.toArray(new String[0]));

        this.repository.save(viewToUpdate);
    }

    /**
     * Elimina una entidad View de la base de datos por su ID.
     *
     * @param id el ID de la entidad View a eliminar
     */
    @Override
    public void delete(Long id) throws Exception {
        Optional<View> op = repository.findById(id);

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
     * @return una página de objetos View que representan los datos de la tabla
     */
    @Override
	public Page<IViewDto> getDatatable(Pageable pageable, String search) throws Exception{
		return repository.getDatatable(pageable, search);
	}	
}
