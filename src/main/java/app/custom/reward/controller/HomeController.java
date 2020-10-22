package app.custom.reward.controller;

import app.custom.reward.entity.Problem;
import app.custom.reward.service.TestBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Controller
public class HomeController {

    LocalDateTime localDt = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy"); // dd-MM-yyyy HH:mm
    String formatDateTime = localDt.format(format);

    @Autowired
    private TestBusinessService testBusinessService;

    @RequestMapping("/")
    public String homePage(Model model) {
        model.addAttribute("pageTitle", "Reward Application");
        model.addAttribute("timeNow", formatDateTime);
        model.addAttribute("problem",testBusinessService.getAllProblems());

        return "index";
    }

    @GetMapping("/testinput")
    public String sendForm(Model model) {
        model.addAttribute("problem", new Problem());
        return "testinput";
    }

    @PostMapping("/testinput")   // @ModelAttribute Problem problem
    public String processForm(@ModelAttribute Problem problem, Model model) {
        model.addAttribute("problem", problem);
        return "output";
    }

}
