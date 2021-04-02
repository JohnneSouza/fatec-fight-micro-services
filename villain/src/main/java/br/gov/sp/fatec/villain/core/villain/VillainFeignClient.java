package br.gov.sp.fatec.villain.core.villain;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "apiarium", url = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/")
public interface VillainFeignClient {

    @GetMapping("/id/{id}.json")
    Villain findById(@PathVariable String id);

    @GetMapping("all.json")
    List<Villain> findAll();

}
