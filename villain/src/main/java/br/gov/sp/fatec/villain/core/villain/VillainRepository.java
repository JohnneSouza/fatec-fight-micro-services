package br.gov.sp.fatec.villain.core.villain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VillainRepository extends MongoRepository<Villain, String> {

    List<Villain> findByNameIsLike(String name);

}
