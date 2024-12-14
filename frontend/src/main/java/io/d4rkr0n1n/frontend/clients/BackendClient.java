package io.d4rkr0n1n.frontend.clients;

import java.util.List;
import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.d4rkr0n1n.frontend.model.Note;

@FeignClient(name = "backend", url = "http://localhost:8080/api/v1")
public interface BackendClient {
  @GetMapping("notes")
  List<Note> getNotes();

  @GetMapping("note")
  Note getNote(UUID id);

  @PostMapping("note/random")
  List<Note> createRandomNote();

  @PostMapping("note")
  Note createNote(@RequestParam String contents);

  @DeleteMapping("note")
  Note deleteNote(@RequestParam UUID id);

  @PutMapping("note")
  void updateNote(@RequestParam UUID id, @RequestParam String updatedContents);
}
