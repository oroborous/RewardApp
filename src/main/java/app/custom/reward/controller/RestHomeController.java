package app.custom.reward.controller;

import app.custom.reward.dto.UserRepository;
import app.custom.reward.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestHomeController {

    @Autowired
    private UserRepository repository;

    @PostMapping("/saveUsers")
    public String saveUser(@RequestBody List<User> users) {
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
