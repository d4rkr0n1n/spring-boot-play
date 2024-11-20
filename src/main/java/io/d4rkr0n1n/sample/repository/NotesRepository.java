package io.d4rkr0n1n.sample.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.d4rkr0n1n.sample.model.Note;

@Repository
public interface NotesRepository extends CrudRepository<Note, UUID> {

}