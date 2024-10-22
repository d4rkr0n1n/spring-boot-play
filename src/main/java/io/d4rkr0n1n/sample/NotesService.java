package io.d4rkr0n1n.sample;

import java.util.ArrayList;
import java.util.List;

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
}
