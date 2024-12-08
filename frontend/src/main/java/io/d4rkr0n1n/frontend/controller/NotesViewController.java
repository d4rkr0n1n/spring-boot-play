package io.d4rkr0n1n.frontend.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.d4rkr0n1n.frontend.clients.BackendClient;
import lombok.extern.java.Log;

@Controller
@Log
public class NotesViewController {

  private final BackendClient backendClient;

  public NotesViewController(BackendClient backendClient) {
    this.backendClient = backendClient;
  }

  @GetMapping("/")
  public String home(Model model) {
    refreshNotesTable(model);
    return "index";
  }

  @PostMapping("/createNote")
  public String addNote(Model model, @RequestParam String contents) {
    backendClient.createNote(contents);
    return refreshNotesTable(model);
  }

  @DeleteMapping("/deleteNote")
  public String deleteNote(Model model, @RequestParam UUID id) {
    backendClient.deleteNote(id);
    return refreshNotesTable(model);
  }

  @PutMapping("/updateNote")
  public String deleteNote(Model model, @RequestParam UUID id, @RequestParam String contents) {
    backendClient.updateNote(id, contents);
    return refreshNotesTable(model);
  }

  private String refreshNotesTable(Model model) {
    model.addAttribute("notes", backendClient.getNotes());
    return "fragments/notesList :: notes";
  }
}
