package academy.itk.repository;

import academy.itk.model.Employee;
import academy.itk.projection.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    @Query("select * from Employee")
    List<EmployeeProjection> findEmployeeProjection();
}
