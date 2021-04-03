package br.gov.sp.fatec.fight.core.villain;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "villain", url = "${service.url.villain}")
public interface VillainFeignClient {

    @GetMapping("/find/random")
    Villain findRandomVillain();

    @GetMapping("{id}")
    Villain findVillainById(@PathVariable String id);

    @GetMapping("/find/name/{name}")
    List<Villain> findVillainByName(@PathVariable String name);

}
