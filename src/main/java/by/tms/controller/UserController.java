package by.tms.controller;

import by.tms.dao.HibernateUserDao;
import by.tms.entity.Operation;
import by.tms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private HibernateUserDao hibernateUserDao;

    @GetMapping("/reg")
    public String create() {
        return "user/reg";
    }

    @PostMapping("/reg")
    public String create(User user) {

        hibernateUserDao.save(user);

        return "user/reg";
    }

    @GetMapping("/profile/{username}")
    @Transactional
    public String profile(@PathVariable String username, Model model) {
        User byUsername = hibernateUserDao.findByUsername(username);
        List<Operation> operations = hibernateUserDao.findAllUserByUsername(username);
        byUsername.setOperations(operations);
        model.addAttribute("user", byUsername);
        return "user/profile";
    }

}
