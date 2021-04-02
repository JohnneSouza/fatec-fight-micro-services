package br.gov.sp.fatec.fight.core.fight;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FightRepository extends MongoRepository<Fight, String> {
}
