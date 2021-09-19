package pl.project.WebNotePad.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface NoteRepository {

    List<Note> findAll();

    Optional<Note> findById();

    Note save(Note entity);

    Page<Note> findAll(Pageable page);

    boolean existsById(Integer id);

    void deleteById(Integer id);
}
