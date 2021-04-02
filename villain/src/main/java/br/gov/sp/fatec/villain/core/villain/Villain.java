package br.gov.sp.fatec.villain.core.villain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Getter
@Setter
@Document("Villain")
public class Villain {

    private String id;
    private String name;
    private VillainPowerStats powerstats;
    Map<String, String> images;

}