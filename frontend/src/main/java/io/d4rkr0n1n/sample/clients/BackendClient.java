package io.d4rkr0n1n.sample.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import io.d4rkr0n1n.sample.model.Note;

@FeignClient(name = "backend", url = "http://localhost:8080")
public interface BackendClient {
  @GetMapping("/api/v1/notes")
  List<Note> getNotes();
}
