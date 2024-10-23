package io.d4rkr0n1n.sample;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class NotesService {

  private final SampleRepository notesRepository;

  public NotesService(SampleRepository sampleRepository) {
    this.notesRepository = sampleRepository;
  }

  public List<Notes> retrieveAllNotes() {
    return (ArrayList<Notes>) notesRepository.findAll();
  }

  public String createNotes() {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    Notes notes = new Notes(UUID.randomUUID(), "Note_" + timestamp);
    notesRepository.save(notes);
    return "Random Note created !!";
  }
}
