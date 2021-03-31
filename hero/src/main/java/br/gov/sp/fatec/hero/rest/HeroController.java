package br.gov.sp.fatec.hero.rest;

import br.gov.sp.fatec.hero.core.hero.Hero;
import br.gov.sp.fatec.hero.core.hero.HeroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/superhero")
public class HeroController {

    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @PostMapping
    public Hero createHero(@RequestBody Hero hero){
        return this.heroService.createHero(hero);
    }

    @GetMapping
    public List<Hero> findAll(){
        return this.heroService.findAll();
    }

    @GetMapping("{id}")
    public Hero findHeroById(@PathVariable String id){
        return this.heroService.findHeroById(id);
    }

    @GetMapping("/find/random")
    public Hero findRandomHero(){
        return this.heroService.findRandomHero();
    }

    @GetMapping("/find/name/{name}")
    public Hero findHeroByName(@PathVariable String name){
        return this.heroService.findHeroByName(name);
    }

    @PostMapping("{id}")
    public Hero createHeroFromId(@PathVariable String id){
        return this.heroService.createFromId(id);
    }
}
