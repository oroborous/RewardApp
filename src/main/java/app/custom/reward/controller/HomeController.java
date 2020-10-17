package app.custom.reward.controller;

import app.custom.reward.dto.UserRepository;
import app.custom.reward.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("pageTitle", "Reward Application");
        return "index";
    }

    @PostMapping("/saveUsers")
    public String saveUser(List<User> users) {
        repository.saveAll(users);
        return users.size() + "record saved..";
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return (List<User>) repository.findAll();
    }

    @GetMapping("/getUserByName/{name}")
    public User findUserByName(@PathVariable String name) {
        return repository.findByName(name);
    }

}
