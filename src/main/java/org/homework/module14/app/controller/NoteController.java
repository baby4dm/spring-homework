package org.homework.module14.app.controller;

import lombok.RequiredArgsConstructor;
import org.homework.module14.app.model.Note;
import org.homework.module14.app.model.requests.CreateNoteRequest;
import org.homework.module14.app.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/list")
    public ResponseEntity<List<Note>> getNoteList() {
        return ResponseEntity.ok(noteService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable Long id){
        return ResponseEntity.ok(noteService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        noteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> edit(@PathVariable("id") Long id, @RequestBody CreateNoteRequest request) {
        return ResponseEntity.ok(noteService.update(id, request));
    }

    @PostMapping()
    public ResponseEntity<Note> createNote(@RequestBody CreateNoteRequest request) {
        return new ResponseEntity<>(noteService.add(request), HttpStatus.CREATED);
    }
}
