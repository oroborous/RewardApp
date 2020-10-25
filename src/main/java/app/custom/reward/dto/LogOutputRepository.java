package app.custom.reward.dto;

import app.custom.reward.entity.LogOutput;
import org.springframework.data.repository.CrudRepository;

public interface LogOutputRepository extends CrudRepository<LogOutput, Integer> {
    //LogOutput findByError(String error);
}
