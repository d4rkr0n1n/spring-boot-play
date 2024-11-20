package io.d4rkr0n1n.sample.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.d4rkr0n1n.sample.model.Notes;
import io.d4rkr0n1n.sample.service.NotesService;

@RestController
@RequestMapping("/api/v1")
public class NotesController {

    private final NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @PostMapping("/post")
    public String post() {
        return notesService.createNotes();
    }

    @GetMapping("/get")
    public List<Notes> get() {
        return notesService.retrieveAllNotes();
    }

    @PutMapping("/put")
    public String put(@RequestParam UUID id, @RequestParam String updatedName) {
        return notesService.updateNotes(id, updatedName);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam UUID id) {
        return notesService.deleteNotes(id);
    }

}
