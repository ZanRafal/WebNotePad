package pl.project.WebNotePad.model;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SqlNoteRepository extends NoteRepository, JpaRepository<Note, Integer> {
}
