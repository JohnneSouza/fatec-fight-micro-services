package br.gov.sp.fatec.fight.core.fight;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Getter
@Setter
@Document("Fight")
public class Fight {

    private String id;
    private Instant fightDate;
    private String winnerName;
    private String winnerPicture;
    private String loserName;
    private String loserPicture;

}
