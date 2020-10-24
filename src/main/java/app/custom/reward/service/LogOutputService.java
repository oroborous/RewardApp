package app.custom.reward.service;

import app.custom.reward.entity.LogOutput;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LogOutputService {

    private List<LogOutput> logOutputList = new ArrayList<>(Arrays.asList(
            new LogOutput("Cell 1", "A23456", "Problem with a server"),
            new LogOutput("Cell 2", "B23456", "Binary output is not correct"),
            new LogOutput("Cell 3", "AB23456", "Execution problem")
    ));

    public List<LogOutput> getAllProblems() {
        // must be repository interface with extended CrudRepository class
        //problemList.findAll().forEach(counts::add);

        return logOutputList;
    }

    public LogOutput getProblem(String error) {
        return logOutputList.stream().filter(p -> p.getError().equals(error)).findFirst().get();
    }

}
