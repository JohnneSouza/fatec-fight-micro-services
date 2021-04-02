package br.gov.sp.fatec.fight.core.hero;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "hero", url = "${service.url.hero}")
public interface HeroFeignClient {

    @GetMapping("/find/random")
    Hero findRandomHero();

    @GetMapping("{id}")
    Hero findHeroById(@PathVariable String id);

    @GetMapping("/find/name/{name}")
    Hero findHeroByName(@PathVariable String name);

}
