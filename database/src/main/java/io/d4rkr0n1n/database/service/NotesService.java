package io.d4rkr0n1n.database.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.d4rkr0n1n.database.model.Note;
import io.d4rkr0n1n.database.repository.NotesRepository;
import lombok.extern.java.Log;

@Service
@Log
public class NotesService {

  private final NotesRepository notesRepository;

  public NotesService(NotesRepository sampleRepository) {
    this.notesRepository = sampleRepository;
  }

  public Long getCount() {
    return notesRepository.count();
  }

  public List<Note> retrieveAllNotes() {
    return (ArrayList<Note>) notesRepository.findAll();
  }

  public Optional<Note> retrieveNote(UUID id) {
    return notesRepository.findById(id);
  }

  public Note saveNote(Note note) {
    return notesRepository.save(note);
  }

  public void deleteNote(Note note) {
    notesRepository.delete(note);
  }
}
