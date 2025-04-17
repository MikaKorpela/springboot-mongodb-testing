package com.pikecape.springboot.testing.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.pikecape.springboot.testing.AbstractMongoRepositoryTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class DuckMongoRepositoryTest extends AbstractMongoRepositoryTest {
  @Autowired
  private DuckMongoRepository repository;

  private final DuckEntity duey = DuckEntity.builder()
      .name("Duey")
      .build();

  private final DuckEntity huey = DuckEntity.builder()
      .name("Huey")
      .build();

  private final DuckEntity luey = DuckEntity.builder()
      .name("Luey")
      .build();

  @BeforeEach
  void setUp() {
    repository.deleteAll();
  }

  @Test
  void testFindAll() {
    repository.create(duey);
    repository.create(huey);
    repository.create(luey);

    List<DuckEntity> result = repository.findAll();

    assertEquals(3, result.size());
  }

  @Test
  void testFindByUid() {
    DuckEntity created = repository.create(duey);

    DuckEntity result = repository.findById(created.getId()).orElse(null);

    assertNotNull(result);
    assertEquals(duey.getName(), result.getName());
  }

  @Test
  void testCreate() {
    DuckEntity result = repository.create(duey);

    assertEquals(duey.getName(), result.getName());
  }

  @Test
  void testUpdate() {
    DuckEntity created = repository.create(duey);

    created.setName("Tupu");

    repository.update(created);

    DuckEntity result = repository.findById(created.getId()).orElse(null);

    assertNotNull(result);
    assertEquals("Tupu", result.getName());
  }

  @Test
  void testDelete() {
    DuckEntity created = repository.create(duey);

    assertEquals(1, repository.findAll().size());

    repository.delete(created);

    assertEquals(0, repository.findAll().size());
  }
}
