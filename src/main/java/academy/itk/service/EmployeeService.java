package academy.itk.service;

import academy.itk.model.Employee;
import academy.itk.projection.EmployeeProjection;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    UUID save(Employee user);

    List<EmployeeProjection> findEmployeeProjection();
}
