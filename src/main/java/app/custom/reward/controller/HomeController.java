package app.custom.reward.controller;

import app.custom.reward.entity.TestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Controller
public class HomeController {

    LocalDateTime localDt = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy"); // dd-MM-yyyy HH:mm
    String formatDateTime = localDt.format(format);

    @RequestMapping("/")
    public String homePage(Model model) {
        model.addAttribute("pageTitle", "Reward Application");
        model.addAttribute("timeNow", formatDateTime);
        return "index";
    }

    @GetMapping("/testinput")
    public String sendForm(Model model) {
        model.addAttribute("user", new TestEntity());
        return "testinput";
    }

    @PostMapping("/testinput")
    public String processForm(@ModelAttribute TestEntity user, Model model) {
        System.out.println("Inside of processForm method in controller");
        return "output";
    }

}
