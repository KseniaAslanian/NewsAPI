package org.example.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {
    Long id;
    @NotBlank
    String title;
    @NotBlank
    String text;
    Instant date;

    public News(String title, String text) {
        this.title = title;
        this.text = text;
    }
}
