package app.custom.reward.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "LOG_OUTPUT")
@Data
@NoArgsConstructor
public class LogOutput {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "resource_name")
    private String resourceName;

    @Column(name = "error_id")
    private String error;

    @Column(name = "description")
    private String description;

}
