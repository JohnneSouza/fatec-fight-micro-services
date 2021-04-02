package br.gov.sp.fatec.fight.core.fight;

import br.gov.sp.fatec.fight.core.hero.Hero;
import br.gov.sp.fatec.fight.core.hero.HeroFeignClient;
import br.gov.sp.fatec.fight.core.villain.Villain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@Slf4j
public class FightService {

    private static final String PICTURE_SIZE = "lg";

    private final HeroFeignClient heroFeignClient;
    private final FightRepository fightRepository;

    public FightService(HeroFeignClient heroFeignClient, FightRepository fightRepository) {
        this.heroFeignClient = heroFeignClient;
        this.fightRepository = fightRepository;
    }

    public List<Fight> findAll(){
        return this.fightRepository.findAll();
    }

    public Fighters findRandomFighters(){
        log.info("Fetching a Random Hero");
        Hero hero = heroFeignClient.findRandomHero();

        log.info("Fetching a Random Villain");
        Villain villain = new Villain();

        return new Fighters(hero, villain);
    }

    public Fight executeFight(Fighters fighters){

        int combatPowerHero = fighters.getHero().getPowerstats().getCombat();
        int combatPowerVillain = fighters.getVillain().getPowerstats().getCombat();

        if (combatPowerHero > combatPowerVillain) {
            log.info("Hero Victory");
            return persistHeroVictory(fighters);
        }

        log.info("Villain Victory");
        return persistVillainVictory(fighters);

    }

    public Fight persistHeroVictory(Fighters fighters){
        Fight fight = new Fight();
        fight.setFightDate(Instant.now());
        fight.setId(generateId());
        fight.setWinnerName(fighters.getHero().getName());
        fight.setWinnerPicture(fighters.getHero().getImages().get(PICTURE_SIZE));
        fight.setLoserName(fighters.getVillain().getName());
        fight.setLoserPicture(fighters.getVillain().getImages().get(PICTURE_SIZE));

        return this.fightRepository.save(fight);
    }

    public Fight persistVillainVictory(Fighters fighters){
        Fight fight = new Fight();
        fight.setFightDate(Instant.now());
        fight.setId(generateId());
        fight.setWinnerName(fighters.getVillain().getName());
        fight.setWinnerPicture(fighters.getVillain().getImages().get(PICTURE_SIZE));
        fight.setLoserName(fighters.getHero().getName());
        fight.setLoserPicture(fighters.getHero().getImages().get(PICTURE_SIZE));

        return this.fightRepository.save(fight);
    }

    private String generateId(){
        return String.valueOf(this.fightRepository.findAll().size() + 1);
    }
}
