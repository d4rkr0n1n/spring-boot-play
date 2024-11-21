package io.d4rkr0n1n.sample.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.d4rkr0n1n.sample.model.Note;
import io.d4rkr0n1n.sample.service.NotesService;

@RestController
@RequestMapping("/api/v1")
public class NotesController {

    private final NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getAllNotes() {
        return notesService.retrieveAllNotes();
    }

    @PostMapping("/note")
    public ResponseEntity<Note> post() {
        return notesService.createNotes();
    }

    @GetMapping("/note")
    public ResponseEntity<Note> getNote(@RequestParam UUID id) {
        return notesService.retrieveNote(id);
    }

    @PutMapping("/note")
    public ResponseEntity<Note> put(@RequestParam UUID id, @RequestParam String updatedContents) {
        return notesService.updateNote(id, updatedContents);
    }

    @DeleteMapping("/note")
    public ResponseEntity<Note> delete(@RequestParam UUID id) {
        return notesService.deleteNote(id);
    }

}
