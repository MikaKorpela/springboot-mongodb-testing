package com.pikecape.springboot.testing.repository;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("duck")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class DuckEntity {
  @Id
  private UUID id;
  private String name;
}
