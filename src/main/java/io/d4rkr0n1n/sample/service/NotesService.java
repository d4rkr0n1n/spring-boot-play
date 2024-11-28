package io.d4rkr0n1n.sample.service;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Service;

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

  public Long checkDB() {

    return notesRepository.count();
  }

  public List<Note> retrieveAllNotes() {
    List<Note> notes = (ArrayList<Note>) notesRepository.findAll();
    for (Note x : notes) {
      Date date = new Date(x.getTimestamp().getTime());
      Time time = new Time(x.getTimestamp().getTime());
      log.info("[" + "Timestamp: " + x.getTimestamp().toString() + " | " + "Date: " + date.toString() + " | " + "Time: "
          + time.toString() + "]");
    }
    return notes;
  }

  public Note createNotes() {
    Timestamp timestamp = TimeUtils.getCurrentTime();
    Note notes = new Note(UUID.randomUUID(), "Note_" + timestamp, "Random Note", timestamp);
    return saveNote(notes);
  }

  public Note createNotesC(String contents) {
    Timestamp timestamp = TimeUtils.getCurrentTime();
    Note notes = new Note(UUID.randomUUID(), "Note_" + timestamp, contents, timestamp);
    return saveNote(notes);
  }

  public Note retrieveNote(UUID id) {
    return findNoteById(id);
  }

  public Note updateNote(UUID id, String updatedContents) {
    Note note = findNoteById(id);
    note.setContents(updatedContents);
    return saveNote(note);
  }

  public Note deleteNote(UUID id) {
    Note note = findNoteById(id);
    notesRepository.delete(note);
    return null;
  }

  private Note saveNote(Note note) {
    return notesRepository.save(note);
  }

  private Note findNoteById(UUID id) throws NoSuchElementException {
    if (notesRepository.findById(id).isPresent()) {
      return notesRepository.findById(id).get();
    } else {
      throw new NoSuchElementException("Note not found");
    }
  }

}
