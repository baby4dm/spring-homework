package org.homework.module14.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.homework.module14.app.model.Note;
import org.homework.module14.app.repo.NoteRepository;
import org.homework.module14.app.service.NoteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    @Override
    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note add(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Note note) {
        Note founded = getById(note.getId());
        founded.setContent(note.getContent());
        founded.setName(note.getName());
        noteRepository.flush();
    }

    @Override
    public Note getById(long id) {
        return noteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format("Entity with id = %s was not founded", id)));
    }

}
