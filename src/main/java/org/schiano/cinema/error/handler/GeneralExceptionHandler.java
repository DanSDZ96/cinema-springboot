package org.schiano.cinema.error.handler;

import org.schiano.cinema.error.exceptions.AttoreNonTrovatoException;
import org.schiano.cinema.error.exceptions.UpdateSenzaIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(AttoreNonTrovatoException.class)
    public ResponseEntity<String> handleAttoreNonTrovato(AttoreNonTrovatoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(UpdateSenzaIdException.class)
    public ResponseEntity<String> handleUpdateSenzaId(UpdateSenzaIdException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
