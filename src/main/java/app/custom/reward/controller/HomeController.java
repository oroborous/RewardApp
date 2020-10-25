package app.custom.reward.controller;

import app.custom.reward.entity.LogOutput;
import app.custom.reward.service.LogOutputService;
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

    @Autowired
    private LogOutputService logOutputService;

    // taking all data from LogOutputService and inserting into Model and passing to the form
    @RequestMapping("/")
    public String homePage(Model model) {

        LocalDateTime localDt = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy"); // dd-MM-yyyy HH:mm
        String formatDateTime = localDt.format(format);

        model.addAttribute("pageTitle", "Reward Application");
        model.addAttribute("timeNow", formatDateTime);
        model.addAttribute("logOutput", logOutputService.getAllProblems());

        return "index";
    }

    // Taking user input into LogOutput and inserting into the Model
    @GetMapping("/testinput")
    public String sendForm(Model model) {
        model.addAttribute("logOutput", new LogOutput());
        return "testinput";
    }

    // Passing the Model to the output form to display
    @PostMapping("/testinput")
    public String processForm(@ModelAttribute LogOutput logOutput, Model model) {
        model.addAttribute("logOutput", logOutput);
        // saving an object
        logOutputService.saveLogOutput(logOutput);
        return "output";
    }

}
