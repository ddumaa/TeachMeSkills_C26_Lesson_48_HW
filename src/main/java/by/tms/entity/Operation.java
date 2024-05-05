package by.tms.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long number1;
    private long number2;
    private String operationType;
    private long result;

    @ToString.Exclude
    @ManyToOne
    private User user;
}
