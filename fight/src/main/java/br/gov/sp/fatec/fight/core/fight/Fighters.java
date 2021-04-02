package br.gov.sp.fatec.fight.core.fight;

import br.gov.sp.fatec.fight.core.hero.Hero;
import br.gov.sp.fatec.fight.core.villain.Villain;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fighters {

    private Hero hero;
    private Villain villain;

    public Fighters(Hero hero, Villain villain) {
        this.hero = hero;
        this.villain = villain;
    }
}
