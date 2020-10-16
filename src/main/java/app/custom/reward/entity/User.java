package app.custom.reward.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "USER_DB")
@Data
@NoArgsConstructor
public class User {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int points;
}
