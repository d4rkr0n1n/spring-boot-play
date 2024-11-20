package io.d4rkr0n1n.sample.service;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.d4rkr0n1n.sample.helper.ResponseHelper;
import io.d4rkr0n1n.sample.model.Note;
import io.d4rkr0n1n.sample.repository.NotesRepository;
import io.d4rkr0n1n.sample.utils.TimeUtils;
import lombok.extern.java.Log;

@Service
@Log
public class NotesService {

  private final NotesRepository notesRepository;

  public NotesService(NotesRepository sampleRepository) {
    this.notesRepository = sampleRepository;
  }

  public ResponseEntity<List<Note>> retrieveAllNotes() {
    List<Note> notes = (ArrayList<Note>) notesRepository.findAll();
    for (Note x : notes) {
      log.info(Long.toString(x.getTimestamp().getTime()));
      Date date = new Date(x.getTimestamp().getTime());
      log.info(date.toString());
      Time time = new Time(x.getTimestamp().getTime());
      log.info(Long.toString(x.getTimestamp().getTime()));
      log.info(time.toString());
    }
    return ResponseHelper.ok(notes);
  }

  public ResponseEntity<Note> createNotes() {
    Timestamp timestamp = TimeUtils.getCurrentTime();
    Note notes = new Note(UUID.randomUUID(), "Note_" + timestamp, "Random Note", timestamp);
    saveNote(notes);
    return ResponseHelper.created(notes);
  }

  public ResponseEntity<Note> retrieveNote(UUID id) {
    Optional<Note> noteId = findNoteById(id);

    if (findNoteById(id).isPresent()) {
      return ResponseHelper.ok(noteId.get());
    } else {
      return ResponseHelper.notFound();
    }
  }

  public ResponseEntity<Note> updateNote(UUID id, String updatedName) {

    Optional<Note> noteId = findNoteById(id);
    ResponseEntity<Note> status = ResponseHelper.notFound();

    if (noteId.isPresent()) {
      Note note = noteId.get();
      note.setName(updatedName);
      saveNote(note);
      status = ResponseHelper.ok(note);
    }

    return status;
  }

  public ResponseEntity<Note> deleteNote(UUID id) {

    Optional<Note> noteId = findNoteById(id);
    ResponseEntity<Note> status = ResponseHelper.notFound();

    if (findNoteById(id).isPresent()) {
      notesRepository.delete(noteId.get());
      status = ResponseHelper.ok();
    }

    return status;
  }

  private void saveNote(Note note) {
    notesRepository.save(note);
  }

  private Optional<Note> findNoteById(UUID id) {
    return notesRepository.findById(id);
  }

}
