package br.gov.sp.fatec.hero.core.hero;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "apiarium", url = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/")
public interface HeroFeignClient {

    @GetMapping("/id/{id}.json")
    Hero findById(@PathVariable String id);

    @GetMapping("all.json")
    List<Hero> findAll();

}
