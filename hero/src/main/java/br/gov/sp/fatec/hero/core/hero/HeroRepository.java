package br.gov.sp.fatec.hero.core.hero;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends MongoRepository<Hero, String> {

    Hero findByNameIsLike(String name);

}
