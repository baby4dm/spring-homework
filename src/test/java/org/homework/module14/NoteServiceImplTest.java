package org.homework.module14;

import org.homework.module14.app.model.Note;
import org.homework.module14.app.model.requests.CreateNoteRequest;
import org.homework.module14.app.repo.NoteRepository;
import org.homework.module14.app.service.impl.NoteServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class NoteServiceImplTest {
    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private NoteServiceImpl noteService;


    @Test
    void testAddNote() {
        CreateNoteRequest request = new CreateNoteRequest("Test Name", "Test Content");
        Note note = new Note();
        note.setName("Test Name");
        note.setContent("Test Content");

        when(noteRepository.save(any(Note.class))).thenReturn(note);

        Note result = noteService.add(request);

        assertNotNull(result);
        assertEquals("Test Name", result.getName());
        assertEquals("Test Content", result.getContent());
        verify(noteRepository, times(1)).save(any(Note.class));
    }
}
