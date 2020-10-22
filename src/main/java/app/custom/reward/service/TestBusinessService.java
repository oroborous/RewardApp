package app.custom.reward.service;

import app.custom.reward.entity.Problem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TestBusinessService {

    private List<Problem> problemList = new ArrayList<>(Arrays.asList(
            new Problem("Panasonic 1", "A23456", "Problem with a server"),
            new Problem("Panasonic 2", "B23456", "Amplifier is done"),
            new Problem("Panasonic 3", "AB23456", "Execution problem")
    ));

    public List<Problem> getAllProblems() {
        // must be repository interface with extended CrudRepository class
        //problemList.findAll().forEach(counts::add);

        return problemList;
    }

    public Problem getProblem(String error) {
        return problemList.stream().filter(p -> p.getError().equals(error)).findFirst().get();
    }

}
