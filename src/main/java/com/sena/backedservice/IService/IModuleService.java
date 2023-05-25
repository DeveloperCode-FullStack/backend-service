package com.sena.backedservice.IService;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.backedservice.Dto.IModuleDto;
import com.sena.backedservice.Entity.Module;

public interface IModuleService {

    /**
     * Recupera todos los módulos existentes.
     *
     * @return una lista de objetos Module que representan todos los módulos existentes
     */
    public List<Module> all() throws Exception;

    /**
     * Recupera un módulo por su ID.
     *
     * @param id el ID del módulo a recuperar
     * @return el objeto Module correspondiente al ID proporcionado, o un Optional vacío si no se encuentra ningún módulo con el ID proporcionado
     */
    public Optional<Module> findById(Long id) throws Exception;

    /**
     * Guarda un módulo en la base de datos.
     *
     * @param module el objeto Module a guardar
     * @return el objeto Module guardado en la base de datos
     */
    public Module save(Module module) throws Exception;

    /**
     * Actualiza un módulo existente en la base de datos.
     *
     * @param id el ID del módulo a actualizar
     * @param module el objeto Module con los datos actualizados
     * @return el objeto Module actualizado
     */
    public void update(Long id, Module module) throws Exception;
    
    /**
     * Elimina un módulo existente de la base de datos.
     *
     * @param id el ID del módulo a eliminar
     */
    public void delete(Long id) throws Exception;
    
    /**
     * Recupera una lista paginada de módulos que coincidan con una cadena de búsqueda.
     *
     * @param pageable información sobre la paginación
     * @param search la cadena de búsqueda para filtrar los módulos
     * @return una página de objetos Module que representan los módulos encontrados
     */
    public Page<IModuleDto> getDatatable(Pageable pageable, String search) throws Exception;
}
