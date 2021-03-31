package br.gov.sp.fatec.hero.core.hero;

import java.util.Collections;

public class HeroStub {

    private HeroStub() {
    }

    public static Hero getHeroStub(){

        Hero hero = new Hero();
        hero.setName("Rick Astley");
        hero.setId("000");
        hero.setImages(Collections.singletonMap("xl", "https://youtu.be/dQw4w9WgXcQ"));

        HeroPowerStats powerStats = new HeroPowerStats();
        powerStats.setPower(9999);
        powerStats.setCombat(9999);
        powerStats.setDurability(9999);
        powerStats.setStrength(9999);
        powerStats.setSpeed(9999);
        powerStats.setIntelligence(9999);

        hero.setPowerstats(powerStats);

        return hero;
    }

}
