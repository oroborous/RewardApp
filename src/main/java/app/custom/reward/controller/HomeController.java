package app.custom.reward.controller;

import app.custom.reward.dto.UserRepository;
import app.custom.reward.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private UserRepository repository;

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
