package io.d4rkr0n1n.frontend.model;

import java.sql.Timestamp;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
  UUID id;
  String name;
  String contents;
  Timestamp timestamp;
}
