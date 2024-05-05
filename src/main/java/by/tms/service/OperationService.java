package by.tms.service;

import by.tms.dao.HibernateOperationDao;
import by.tms.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService {

    @Autowired
    private HibernateOperationDao hibernateOperationDao;

    public Operation calculate(Operation operation) {
        switch (operation.getOperationType()) {
            case "+":
                operation.setResult(operation.getNumber1() + operation.getNumber2());
                return operation;
            case "-":
                operation.setResult(operation.getNumber1() - operation.getNumber2());
                return operation;
            case "*":
                operation.setResult(operation.getNumber1() * operation.getNumber2());
                return operation;
            case "/":
                operation.setResult(operation.getNumber1() / operation.getNumber2());
                return operation;
        }
        throw new IllegalArgumentException();
    }
}
