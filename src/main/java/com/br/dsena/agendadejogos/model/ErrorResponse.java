package com.br.dsena.agendadejogos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Collection;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class ErrorResponse {

    private String message;
    private Collection<ErrorMessage> errors;

    public static ErrorResponse createFromValidation(MethodArgumentNotValidException methodArgumentNotValidException) {
        var violations =
                methodArgumentNotValidException
                        .getFieldErrors()
                        .stream()
                        .map(cv -> new ErrorMessage(cv.getField(), cv.getDefaultMessage()))
                        .collect(Collectors.toList());
        return new ErrorResponse("Validation Errors", violations);

    }
}
