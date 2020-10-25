package app.custom.reward.service;

import app.custom.reward.dto.LogOutputRepository;
import app.custom.reward.entity.LogOutput;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LogOutputService implements LogOutService {

    @Autowired
    private LogOutputRepository logOutputRepository;

    List<LogOutput> problemList = new ArrayList<>();

    public List<LogOutput> getAllProblems() {
        logOutputRepository.findAll().forEach(problemList::add);

        return problemList;
    }

    @Override
    public void saveLogOutput(LogOutput logOutput) {
        logOutputRepository.save(logOutput);
        System.out.println("Saved successfully");
    }

    @Override
    public LogOutput getProblem(String error) {
        return problemList.stream().filter(p -> p.getError().equals(error)).findFirst().get();
    }

}
