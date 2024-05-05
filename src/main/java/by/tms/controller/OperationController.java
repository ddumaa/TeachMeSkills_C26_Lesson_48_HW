package by.tms.controller;

import by.tms.dao.HibernateOperationDao;
import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    private HibernateOperationDao hibernateOperationDao;
    OperationService operationService;

    @GetMapping("/new")
    public String createOperation() {
        return "operation/new";
    }

    @PostMapping("/new")
    public String createOperation(Operation operation) {


        Operation operationResult = operationService.calculate(operation);

        User user = new User();
        user.setId(operation.getUser().getId());
        operationResult.setUser(user);

        hibernateOperationDao.save(operationResult);
        return "redirect:/operation/history";
    }

    @GetMapping("/history")
    public String listOperation(Model model) {
        List<Operation> all = hibernateOperationDao.findAll();
        model.addAttribute("operationList", all);
        return "operation/history";
    }

}
