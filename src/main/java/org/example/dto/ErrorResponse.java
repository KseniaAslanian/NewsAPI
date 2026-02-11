package org.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.util.Map;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private Instant timeStamp;
    private Integer status;
    private String message;
    private Map<String, String> validationErrors;
    private String path;

    public ErrorResponse(Instant timeStamp, int status, String message, String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
