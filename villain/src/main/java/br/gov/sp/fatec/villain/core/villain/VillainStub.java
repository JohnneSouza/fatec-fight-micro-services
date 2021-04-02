package br.gov.sp.fatec.villain.core.villain;

import java.util.Collections;

public class VillainStub {

    private VillainStub() {
    }

    public static Villain getVillainStub(){

        Villain villain = new Villain();
        villain.setName("Rick Astley");
        villain.setId("000");
        villain.setImages(Collections.singletonMap("xl", "https://youtu.be/dQw4w9WgXcQ"));

        VillainPowerStats powerStats = new VillainPowerStats();
        powerStats.setPower(9999);
        powerStats.setCombat(9999);
        powerStats.setDurability(9999);
        powerStats.setStrength(9999);
        powerStats.setSpeed(9999);
        powerStats.setIntelligence(9999);

        villain.setPowerstats(powerStats);

        return villain;
    }

}
