package br.gov.sp.fatec.villain.rest;

import br.gov.sp.fatec.villain.core.villain.Villain;
import br.gov.sp.fatec.villain.core.villain.VillainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/supervillain")
public class VillainController {
    
    private final VillainService villainService;

    public VillainController(VillainService villainService) {
        this.villainService = villainService;
    }
    
    @PostMapping
    public Villain createVillain(@RequestBody Villain villain){
        return this.villainService.createVillain(villain);
    }
    
    @GetMapping
    public List<Villain> findAll(){
        return this.villainService.findAll();
    }
    
    @GetMapping("{id}")
    public Villain findVillainById(@PathVariable String id){
        return  this.villainService.findVillainById(id);
    }

    @GetMapping("/find/random")
    public Villain findRandomVillain(){
        return this.villainService.findRandomVillain();
    }

    @GetMapping("/find/name/{name}")
    public List<Villain> findVillainByName(@PathVariable String name){
        return this.villainService.findVillainByName(name);
    }

    @PostMapping("{id}")
    public Villain createVillainFromId(@PathVariable String id){
        return this.villainService.createFromId(id);
    }
}
