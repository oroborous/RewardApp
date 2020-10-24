package app.custom.reward.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LogOutput {

    private String resourceName;

    private String error;

    private String description;

    public LogOutput(String resourceName, String error, String description) {
        this.resourceName = resourceName;
        this.error = error;
        this.description = description;
    }
}
