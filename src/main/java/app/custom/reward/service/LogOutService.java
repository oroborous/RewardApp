package app.custom.reward.service;

import app.custom.reward.entity.LogOutput;

import java.util.List;

public interface LogOutService {

    void saveLogOutput(LogOutput sighting);

    LogOutput getProblem(String error);
}
