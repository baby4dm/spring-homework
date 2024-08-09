package org.homework.module14.app.model.requests;

import jakarta.validation.constraints.NotBlank;

public record CreateNoteRequest(
        @NotBlank(message = "Name is required")
        String name,
        @NotBlank(message = "Content is required")
        String content
) {
}
