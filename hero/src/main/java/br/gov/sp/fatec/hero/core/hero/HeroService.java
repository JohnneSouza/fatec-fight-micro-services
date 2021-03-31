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
        return this.repository.findAll();
    }

    public Hero findHeroById(String id){
        return this.repository.findById(id)
                .orElse(HeroStub.getHeroStub());
    }

    public Hero findHeroByName(String name){
        return this.repository.findByNameIsLike(name);
    }

    public Hero createFromId(String id){
        Hero hero = this.heroFeignClient.findById(id);
        return createHero(hero);
    }

    public Hero findRandomHero(){
        List<Hero> all = this.repository.findAll();
        Collections.shuffle(all);
        return all.get(0);
    }

}
