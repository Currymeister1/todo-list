package com.todlist.backend.DTO;

import java.time.LocalDate;

public record TaskDTO(Long id, String name, String description, LocalDate started, LocalDate ended, String issuer, String category) {
}
