package br.gov.sp.fatec.hero.core.hero;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class HeroService {

    private final HeroRepository repository;
    private final HeroFeignClient heroFeignClient;

    public HeroService(HeroRepository repository, HeroFeignClient heroFeignClient) {
        this.repository = repository;
        this.heroFeignClient = heroFeignClient;
    }

    public Hero createHero(Hero hero){
        return this.repository.save(hero);
    }

    public List<Hero> findAll(){
        log.info("Retrieving all Heroes from Database");
        return this.repository.findAll();
    }

    public Hero findHeroById(String id){
        log.info("[{}] Find Hero by Id", id);
        return this.repository.findById(id)
                .orElse(HeroStub.getHeroStub());
    }

    public Hero findHeroByName(String name){
        log.info("[{}] Find hero by name", name);
        return this.repository.findByNameIsLike(name);
    }

    public Hero createFromId(String id){
        log.info("[{}] Create Hero from Id", id);
        Hero hero = this.heroFeignClient.findById(id);
        log.info("[{}] Found hero", hero.getName());
        return createHero(hero);
    }

    public Hero findRandomHero(){
        log.info("Find Random Hero");
        List<Hero> heroesList = this.repository.findAll();
        log.info("[{}] Heroes were found", heroesList.size());
        Collections.shuffle(heroesList);
        return heroesList.get(0);
    }

}
