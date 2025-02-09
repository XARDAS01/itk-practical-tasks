package academy.itk.service.impl;

import academy.itk.model.Employee;
import academy.itk.projection.EmployeeProjection;
import academy.itk.repository.EmployeeRepository;
import academy.itk.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository userRepository;

    @Override
    public UUID save(Employee user) {
        return userRepository.save(user).getId();
    }

    @Override
    public List<EmployeeProjection> findEmployeeProjection() {
        return userRepository.findEmployeeProjection();
    }
}
