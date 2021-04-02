package br.gov.sp.fatec.fight.rest;

import br.gov.sp.fatec.fight.core.fight.Fight;
import br.gov.sp.fatec.fight.core.fight.FightService;
import br.gov.sp.fatec.fight.core.fight.Fighters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("fight")
public class FightController {

    private final FightService fightService;

    public FightController(FightService fightService) {
        this.fightService = fightService;
    }

    @GetMapping("/fighters")
    public Fighters findRandomFighters(){
        return this.fightService.findRandomFighters();
    }

    @GetMapping
    public List<Fight> findAllFights(){
        return this.fightService.findAll();
    }

    @PostMapping
    public Fight executeFight(@RequestBody Fighters fighters){
        return this.fightService.executeFight(fighters);
    }


}
