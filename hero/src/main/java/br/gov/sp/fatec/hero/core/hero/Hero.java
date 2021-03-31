package br.gov.sp.fatec.hero.core.hero;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Getter
@Setter
@Document("Hero")
public class Hero {

    private String id;
    private String name;
    private HeroPowerStats powerstats;
    Map<String, String> images;

}
