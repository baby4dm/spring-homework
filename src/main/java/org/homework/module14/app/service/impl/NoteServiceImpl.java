package org.homework.module14.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.homework.module14.app.model.Note;
import org.homework.module14.app.model.requests.CreateNoteRequest;
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
    public Note add(CreateNoteRequest request) {
        Note note = new Note();
        note.setName(request.name());
        note.setContent(request.content());
        return noteRepository.save(note);
    }

    @Override
    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Note update(Long id, CreateNoteRequest request) {
        Note founded = getById(id);
        founded.setContent(request.content());
        founded.setName(request.name());
        noteRepository.flush();
        return founded;
    }

    @Override
    public Note getById(long id) {
        return noteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format("Entity with id = %s was not founded", id)));
    }

}
