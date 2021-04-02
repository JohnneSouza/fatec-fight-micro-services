package br.gov.sp.fatec.villain.core.villain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class VillainService {

    private final VillainRepository villainRepository;
    private final VillainFeignClient villainFeignClient;

    public VillainService(VillainRepository repository, VillainFeignClient heroFeignClient) {
        this.villainRepository = repository;
        this.villainFeignClient = heroFeignClient;
    }

    public Villain createVillain(Villain villain){
        log.info("[{}] Creating a new Villain", villain.getName());
        return this.villainRepository.save(villain);
    }

    public List<Villain> findAll(){
        log.info("Retrieving all Villains from Database");
        return this.villainRepository.findAll();
    }

    public Villain findVillainById(String id){
        log.info("[{}] Find Villain by Id", id);
        return this.villainRepository.findById(id)
                .orElse(VillainStub.getVillainStub());
    }

    public List<Villain> findVillainByName(String name){
        log.info("[{}] Find Villain by name", name);
        return this.villainRepository.findByNameIsLike(name);
    }

    public Villain createFromId(String id){
        log.info("[{}] Create villain from Id", id);
        Villain villain = this.villainFeignClient.findById(id);
        log.info("[{}] Found villain", villain.getName());
        return createVillain(villain);
    }

    public Villain findRandomVillain(){
        log.info("Find Random Villain");
        List<Villain> heroesList = this.villainRepository.findAll();
        log.info("[{}] Villains were found", heroesList.size());
        Collections.shuffle(heroesList);
        return heroesList.get(0);
    }
}
