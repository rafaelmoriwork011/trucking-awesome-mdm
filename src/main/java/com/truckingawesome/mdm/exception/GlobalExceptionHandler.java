package com.truckingawesome.mdm.exception;

import com.truckingawesome.mdm.dto.response.ErrorResponseDto;
import com.truckingawesome.mdm.dto.response.FieldErrorDto;
import com.truckingawesome.mdm.helper.ValidationExceptionHelper;
import com.truckingawesome.mdm.mapper.response.ErrorResponseMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final ErrorResponseMapper errorResponseMapper;
    private final ValidationExceptionHelper validationExceptionHelper;

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleEntityNotFound(EntityNotFoundException ex, HttpServletRequest request) {
        ErrorResponseDto dto = errorResponseMapper.toDTO(ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<FieldErrorDto> fieldErrors = validationExceptionHelper.toFieldDTOList(ex.getBindingResult().getFieldErrors());

        var messages = new ArrayList<String>();
        messages.add("Um ou mais erros de validação encontrados.");

        ErrorResponseDto dto = ErrorResponseDto.builder().messages(messages).fieldErrors(fieldErrors).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponseDto> handleResponseStatus(ResponseStatusException ex, HttpServletRequest request) {

        String message = ex.getReason() != null ? ex.getReason() : ex.getMessage();

        ErrorResponseDto dto = ErrorResponseDto.builder().messages(List.of(message)).build();

        return ResponseEntity.status(ex.getStatusCode()).body(dto);
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponseDto> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        var messages = new ArrayList<String>();
        messages.add("Requisição com parâmetro inválido");

        ErrorResponseDto dto = ErrorResponseDto.builder().messages(messages).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }


    @ExceptionHandler({MissingServletRequestParameterException.class, MissingPathVariableException.class})
    public ResponseEntity<ErrorResponseDto> handleMissingParams() {
        var messages = new ArrayList<String>();
        messages.add("Requisição com parâmetro ausente");

        ErrorResponseDto dto = ErrorResponseDto.builder().messages(messages).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponseDto> handleMissingBody() {
        var messages = new ArrayList<String>();
        messages.add("O corpo da requisição é obrigatório e não foi informado");

        ErrorResponseDto dto = ErrorResponseDto.builder().messages(messages).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleNotFound(NoResourceFoundException ex) {
        var messages = new ArrayList<String>();
        messages.add("Recurso ou rota não encontrada para a URL solicitada");

        ErrorResponseDto dto = ErrorResponseDto.builder().messages(messages).build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseDto> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        var messages = new ArrayList<String>();
        messages.add("Registro está em uso e não pode ser excluído");

        ErrorResponseDto dto = ErrorResponseDto.builder().messages(messages).build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
    }

}
