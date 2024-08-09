package org.homework.module14.app.service;

import org.homework.module14.app.model.Note;
import org.homework.module14.app.model.requests.CreateNoteRequest;

import java.util.List;

public interface NoteService {
    List<Note> listAll();
    Note add(CreateNoteRequest note);
    void deleteById(long id);
    Note update(Long id, CreateNoteRequest request);
    Note getById(long id);
}
