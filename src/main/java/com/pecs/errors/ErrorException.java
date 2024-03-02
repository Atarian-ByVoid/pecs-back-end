package com.pecs.errors;

import java.util.ArrayList;

import org.springframework.http.HttpStatusCode;

import com.pecs.representation.external.ErrorDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("unchecked")
public class ErrorException extends RuntimeException {
    HttpStatusCode statusCode;
    String message;
    String error;

    public ErrorException(final ErrorDTO body) {
        this.statusCode = HttpStatusCode.valueOf(body.getStatusCode());
        this.error = body.getError();

        final Object message = body.getMessage();
        this.message = message instanceof String ? (String) message
                : message != null ? String.join(", ", (ArrayList<String>) message)
                        : "Mensagem de erro não especificada.";
    }

    public ErrorException(final HttpStatusCode statusCode, final String message, final String error) {
        this.statusCode = statusCode;
        this.message = message;
        this.error = error;
    }

    public ErrorException(final HttpStatusCode statusCode, final String error) {
        this.statusCode = statusCode;
        this.error = error;
    }

    public ErrorException(final int statusCode, final String message, final String error) {
        this.statusCode = HttpStatusCode.valueOf(statusCode);
        this.message = message;
        this.error = error;
    }
}
