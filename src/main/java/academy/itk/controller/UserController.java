package academy.itk.controller;

import academy.itk.model.Employee;
import academy.itk.projection.EmployeeProjection;
import academy.itk.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public record UserController(EmployeeService employeeService) {

    @PostMapping
    public ResponseEntity<UUID> createUser(Employee employee) {
        return ResponseEntity.ok().body(employeeService.save(employee));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeProjection>> getProjection() {
        return ResponseEntity.ok().body(employeeService.findEmployeeProjection());
    }
}
