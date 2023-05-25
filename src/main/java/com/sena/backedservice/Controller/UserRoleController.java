package com.sena.backedservice.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sena.backedservice.Dto.ApiResponseDto;
import com.sena.backedservice.Entity.UserRole;
import com.sena.backedservice.Service.UserRoleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/security/userRole")
public class UserRoleController {

    @Autowired
    private UserRoleService service;

    @Operation(summary = "Obtener todos los roles de usuario", responses = {
            @ApiResponse(responseCode = "200", description = "Lista de roles de usuario obtenida"),
            @ApiResponse(responseCode = "404", description = "No se encontraron roles de usuario")
    })
    @GetMapping
    public List<UserRole> all() throws Exception{
        return service.all();
    }

    @Operation(summary = "Obtener un rol de usuario por ID", responses = {
            @ApiResponse(responseCode = "200", description = "Rol de usuario encontrado"),
            @ApiResponse(responseCode = "404", description = "Rol de usuario no encontrado")
    })
    @GetMapping("{id}")
    public Optional<UserRole> show(@PathVariable Long id) throws Exception{
        return service.findById(id);
    }

    @Operation(summary = "Crear un nuevo rol de usuario", responses = {
            @ApiResponse(responseCode = "201", description = "Rol de usuario creado")
    })
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserRole save(@RequestBody UserRole userRole) throws Exception{
        return service.save(userRole);
    }

    @Operation(summary = "Actualizar un rol de usuario existente", responses = {
            @ApiResponse(responseCode = "200", description = "Rol de usuario actualizado"),
            @ApiResponse(responseCode = "404", description = "Rol de usuario no encontrado")
    })
    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserRole update(@PathVariable Long id, @RequestBody UserRole userRole) throws Exception{
        Optional<UserRole> op = service.findById(id);

        if (op.isPresent()) {
            UserRole userRoleToUpdate = op.get();
            BeanUtils.copyProperties(userRole, userRoleToUpdate, "id");
            return service.save(userRoleToUpdate);
        }

        return userRole;
    }

    @Operation(summary = "Eliminar un rol de usuario existente", responses = {
        @ApiResponse(responseCode = "204", description = "Rol de usuario eliminado"),
        @ApiResponse(responseCode = "404", description = "Rol de usuario no encontrado")
    })
    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws Exception{
        service.delete(id);
    }
    
    /**
     * Obtiene los datos para una tabla utilizando paginación y búsqueda.
     *
     * @param page            el número de página
     * @param size            el tamaño de página
     * @param columnOrder     el nombre de la columna para ordenar
     * @param columnDirection la dirección de ordenamiento de la columna (ascendente o descendente)
     * @param search          el término de búsqueda para filtrar los datos de la tabla (opcional)
     * @return ResponseEntity que contiene un objeto ApiResponseDto con los datos de la página y el estado de la respuesta
     */
    @GetMapping("/datatable")
    public ResponseEntity<ApiResponseDto<Page<?>>> datatable(@RequestParam(name = "page") Integer page,
            @RequestParam(name = "size") Integer size,
            @RequestParam(name = "column_order") String columnOrder,
            @RequestParam(name = "column_direction") String columnDirection,
            @RequestParam(name = "search", required = false) String search) {
        try {
            List<Order> orders = new ArrayList<>();

            orders.add(new Order(columnDirection == "asc" ? Direction.ASC : Direction.DESC, columnOrder));

            return ResponseEntity.ok(new ApiResponseDto<Page<?>>("Datos obtenidos",
                    service.getDatatable(PageRequest.of(page, size, Sort.by(orders)), search), true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<Page<?>>(e.getMessage(), null, false));
        }
    }
}