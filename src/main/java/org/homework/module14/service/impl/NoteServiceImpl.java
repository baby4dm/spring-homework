package org.homework.module14.service.impl;

import lombok.RequiredArgsConstructor;
import org.homework.module14.dao.NoteDAO;
import org.homework.module14.model.Note;
import org.homework.module14.service.NoteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteDAO noteDAO;

    @Override
    public List<Note> listAll() {
        return noteDAO.listAll();
    }

    @Override
    public Note add(Note note) {
        return noteDAO.add(note);
    }

    @Override
    public void deleteById(long id) {
        noteDAO.deleteById(id);
    }

    @Override
    public void update(Note note) {
        noteDAO.update(note);
    }

    @Override
    public Note getById(long id) {
        return noteDAO.getById(id).orElseThrow(IllegalArgumentException::new);
    }
}
