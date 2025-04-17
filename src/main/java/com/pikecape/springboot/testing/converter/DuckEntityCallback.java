package com.pikecape.springboot.testing.converter;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import com.pikecape.springboot.testing.repository.DuckEntity;
import java.util.UUID;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertCallback;
import org.springframework.stereotype.Component;

@Component
public class DuckEntityCallback implements BeforeConvertCallback<DuckEntity> {
  @Override
  public DuckEntity onBeforeConvert(
      @NonNull DuckEntity entity,
      @Nullable String collection
  ) {
    if (entity.getId() == null) {
      entity.setId(UUID.randomUUID());
    }

    return entity;
  }
}
