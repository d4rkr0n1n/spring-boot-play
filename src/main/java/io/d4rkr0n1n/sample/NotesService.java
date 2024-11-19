package io.d4rkr0n1n.sample;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.d4rkr0n1n.sample.utils.TimeUtils;

@Service
public class NotesService {

  private final NotesRepository notesRepository;

  public NotesService(NotesRepository sampleRepository) {
    this.notesRepository = sampleRepository;
  }

  public List<Notes> retrieveAllNotes() {
    return (ArrayList<Notes>) notesRepository.findAll();
  }

  public String createNotes() {
    Timestamp timestamp = TimeUtils.getCurrentTime();
    Notes notes = new Notes(UUID.randomUUID(), "Note_" + timestamp);
    saveNote(notes);
    return "Random Note created !!";
  }

  public String updateNotes(UUID id, String updatedName) {

    Optional<Notes> noteId = findNoteById(id);
    String status = "Note Not Found !!";

    if (noteId.isPresent()) {
      Notes note = noteId.get();
      note.setName(updatedName);
      saveNote(note);
      status = "Note Updated !!";
    }

    return status;
  }
  
  public String deleteNotes(UUID id) {
    
    Optional<Notes> noteId = findNoteById(id);
    String status = "Note Not Found !!";
    
    if (findNoteById(id).isPresent()) {
      notesRepository.delete(noteId.get());
      status = "Note Deleted !!";
    }
    
    return status;
  }

  private void saveNote(Notes note) {
    notesRepository.save(note);
  }

  private Optional<Notes> findNoteById(UUID id) {
    return notesRepository.findById(id);
  }
}
