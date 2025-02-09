package academy.itk.model;

import academy.itk.enums.PositionType;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.UUID;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue
    private UUID id;

    private String firstName;
    private String lastName;
    private PositionType position;
    private BigInteger salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}
