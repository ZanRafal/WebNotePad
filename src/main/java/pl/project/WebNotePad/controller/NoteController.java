package pl.project.WebNotePad.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.WebNotePad.model.Note;
import pl.project.WebNotePad.model.NoteRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class NoteController {
    private static final Logger logger = LoggerFactory.getLogger(NoteController.class);
    @NotNull private final NoteRepository noteRepository;

    @GetMapping(value = "/notes", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Note>> readAllNotes () {
        logger.warn("Displaying list of notes");
        return ResponseEntity.ok(noteRepository.findAll());
    }

    @GetMapping(value = "/notes")
    ResponseEntity<List<Note>> readAllNotes (Pageable page) {
        logger.warn("Displaying list of notes with Pageable");
        return ResponseEntity.ok(noteRepository.findAll(page).getContent());
    }

    @GetMapping("/notes/{id}")
    ResponseEntity<Note> readNote(@PathVariable int id) {
        return noteRepository.findById()
                .map(note -> ResponseEntity.ok(note))
                .orElse(ResponseEntity.notFound().build());
    }


}
