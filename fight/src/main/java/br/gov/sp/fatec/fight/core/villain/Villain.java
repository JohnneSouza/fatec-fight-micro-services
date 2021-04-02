package br.gov.sp.fatec.fight.core.villain;

import br.gov.sp.fatec.fight.core.character.CharacterPowerStats;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Villain {

    private String id;
    private String name;
    private CharacterPowerStats powerstats;
    Map<String, String> images;

}
