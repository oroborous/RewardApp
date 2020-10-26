package app.custom.reward.service;

import app.custom.reward.dto.LogOutputRepository;
import app.custom.reward.entity.LogOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class LogOutputService implements LogOutService {

    @Autowired
    private LogOutputRepository logOutputRepository;

    public List<LogOutput> getAllProblems() {
        List<LogOutput> problemList = new ArrayList<>();
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
        List<LogOutput> problemList = new ArrayList<>();
        return problemList.stream().filter(p -> p.getError().equals(error)).findFirst().get();
    }

}
