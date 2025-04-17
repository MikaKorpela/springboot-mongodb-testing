package com.pikecape.springboot.testing.repository;

import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuckMongoRepository extends MongoRepository<DuckEntity, UUID> {
  default DuckEntity create(DuckEntity duck) {
    return save(duck);
  }

  default DuckEntity update(DuckEntity duck) {
    return save(duck);
  }
}
