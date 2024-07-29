package kz.thquiet.employee_crud.controller;

import kz.thquiet.employee_crud.dto.EmployeeDTO;
import kz.thquiet.employee_crud.dto.EmployeeListDTO;
import kz.thquiet.employee_crud.dto.EmployeeSpecialDTO;
import kz.thquiet.employee_crud.dto.EmployeeToCreateDTO;
import kz.thquiet.employee_crud.repository.EmployeeRepository;
import kz.thquiet.employee_crud.service.EmployeeService;
import kz.thquiet.employee_crud.util.Constant;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = Constant.EMPLOYEE_ENDPOINT , produces = "application/json")
@RequiredArgsConstructor
@Slf4j
public class EmployeeContoller {

    private final EmployeeService service;

//    @Operation(summary = "Добавить сведения о управлении данных работников")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Сведения о управлении данных работников успешно добавлены"),
//            @ApiResponse(responseCode = "400", description = "Неверные параметры запроса"),
//            @ApiResponse(responseCode = "401", description = "Неавторизован"),
//            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
//    })
    @SneakyThrows
    @PostMapping("/add")
    public ResponseEntity<EmployeeDTO> add(@RequestBody EmployeeToCreateDTO dto) {
        return ResponseEntity.ok(service.add(dto));
    }

//    @Operation(summary = "Получить сведения о управлении данных работников по идентификатору")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Сведения о управлении данных работников успешно получены"),
//            @ApiResponse(responseCode = "400", description = "Неверный идентификатор"),
//            @ApiResponse(responseCode = "404", description = "Сведения о статусе Wn не найдены"),
//            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
//    })
    @SneakyThrows
    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeDTO> get(@PathVariable Integer id) {
        EmployeeDTO dto = service.get(id);
        return ResponseEntity.ok(dto);
    }

//    @Operation(summary = "Изменить сведения о управлении данных работников")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Сведения о управлении данных работников успешно изменены"),
//            @ApiResponse(responseCode = "400", description = "Неверные параметры запроса"),
//            @ApiResponse(responseCode = "401", description = "Неавторизован"),
//            @ApiResponse(responseCode = "404", description = "Сведения о статусе Wn не найдены"),
//            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
//    })
    @SneakyThrows
    @PatchMapping("/update/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable Integer id, @RequestBody EmployeeToCreateDTO dto) {
        service.updateById(id, dto);
        return ResponseEntity.ok().build();
    }

//    @Operation(summary = "Удалить сведения о управлении данных работников")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Сведения о управлении данных работников успешно удалены"),
//            @ApiResponse(responseCode = "400", description = "Неверный идентификатор"),
//            @ApiResponse(responseCode = "401", description = "Неавторизован"),
//            @ApiResponse(responseCode = "404", description = "Сведения о статусе Wn не найдены"),
//            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
//    })
    @SneakyThrows
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EmployeeDTO> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

//    @Operation(summary = "Получить список сведений о управлении данных работников")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Список сведений о управлении данных работников успешно получен"),
//            @ApiResponse(responseCode = "400", description = "Неверные параметры запроса"),
//            @ApiResponse(responseCode = "401", description = "Неавторизован"),
//            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
//    })
    @SneakyThrows
    @PostMapping("/list")
    public ResponseEntity<List<EmployeeSpecialDTO>> getList(@RequestBody EmployeeListDTO dto) {
        return ResponseEntity.ok(service.getList(dto));
    }
}
