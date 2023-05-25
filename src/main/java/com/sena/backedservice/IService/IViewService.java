package com.sena.backedservice.IService;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.backedservice.Dto.IViewDto;
import com.sena.backedservice.Entity.View;

public interface IViewService {
	
    /**
     * Recupera todos las vistas existentes.
     *
     * @return una lista de objetos View que representan todas las vistas existentes
     */
    public List<View> all() throws Exception;

    /**
     * Recupera una vista por su ID.
     *
     * @param id el ID de la vista a recuperar
     * @return el objeto View correspondiente al ID proporcionado, o un Optional vacío si no se encuentra ninguna vista con el ID proporcionado
     */
    public Optional<View> findById(Long id) throws Exception;

    /**
     * Guarda una vista en la base de datos.
     *
     * @param view el objeto View a guardar
     * @return el objeto View guardado en la base de datos
     */
    public View save(View view) throws Exception;

    /**
     * Actualiza una vista existente en la base de datos.
     *
     * @param id el ID de la vista a actualizar
     * @param view el objeto View con los datos actualizados
     * @return el objeto View actualizado
     */
    public void update(Long id, View view) throws Exception;

    /**
     * Elimina una vista existente de la base de datos.
     *
     * @param id el ID de la vista a eliminar
     */
    public void delete(Long id) throws Exception;

    /**
     * Recupera una página de vistas que coincidan con una cadena de búsqueda.
     *
     * @param pageable información sobre la paginación
     * @param search la cadena de búsqueda para filtrar las vistas
     * @return una página de objetos View que representan las vistas encontradas
     */
    public Page<IViewDto> getDatatable(Pageable pageable, String search) throws Exception;
}
