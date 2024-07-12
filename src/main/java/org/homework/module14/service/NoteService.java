package org.homework.module14.service;

import org.homework.module14.model.Note;

import java.util.List;

public interface NoteService {
    List<Note> listAll();
    Note add(Note note);
    void deleteById(long id);
    void update(Note note);
    Note getById(long id);
}
