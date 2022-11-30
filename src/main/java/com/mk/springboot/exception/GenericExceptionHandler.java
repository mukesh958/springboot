package com.mk.springboot.exception;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
@ControllerAdvice
public class GenericExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericExceptionHandler.class);

    private final MessageSource messageSource;
    private static final String FIVE_HUNDRED = "500";
    private static final String ATTRIBUTE_CODE_ERROR = "EAV_ATTRIBUTE_ENTITY_TYPE_ID_ATTRIBUTE_CODE";

    @Autowired
    private GlobalExceptionEntityCreater globalExceptionEntityCreater;

    @Autowired
    public GenericExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
    	ex.printStackTrace();
        LOGGER.error("Error message :{}, {}", ex.getMessage(), ex.getStackTrace());
        return new ResponseEntity<>(globalExceptionEntityCreater.createGlobalException("", ex.getMessage(), null),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleRunTimeException(RuntimeException ex) {
		ex.printStackTrace();
		LOGGER.error("Error message :{}, {}", ex.getMessage(), ex.getStackTrace());
		return new ResponseEntity<>(globalExceptionEntityCreater.createGlobalException("Something went wrong on server",
                ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
	}

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleInvalidFormatException(InvalidFormatException ex) {
        ex.printStackTrace();
        LOGGER.error("Error message :{}, {}", ex.getMessage(), ex.getStackTrace());
        List<String> errorsList = new ArrayList<>();
        Class<?> type = ex.getTargetType();
        if (type != null) {
            return new ResponseEntity<>(globalExceptionEntityCreater.createGlobalException(Collections.singletonList("The parameter of '" + type.getSimpleName() + " must have a value among:" + StringUtils.join(type.getEnumConstants(), ", ")), "Invalid request"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        ex.getPath().forEach(reference -> errorsList.add("Value of '" + reference.getFieldName() + " not a valid representation"));
        return new ResponseEntity<>(globalExceptionEntityCreater.createGlobalException(errorsList, "Invalid request"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

	/*
	 * @ExceptionHandler(GenericException.class) public ResponseEntity<?>
	 * handleException(GenericException ex, Locale locale) {
	 * LOGGER.error("Error message :{}, {}", ex.getErrorMessage(), ex);
	 * if(!ObjectUtils.isEmpty(ex.getErrorsList())){ return new ResponseEntity<>(
	 * globalExceptionEntityCreater.createGlobalException(ex.getErrorsList()),
	 * HttpStatus.INTERNAL_SERVER_ERROR); } String userMessage =
	 * ex.getUserMessage(); if (Objects.isNull(userMessage)) { String errorCode =
	 * ObjectUtils.isEmpty(ex.getErrorCode()) ? FIVE_HUNDRED : ex.getErrorCode();
	 * userMessage = messageSource.getMessage(errorCode, new Object[] {}, locale); }
	 * return new ResponseEntity<>(
	 * globalExceptionEntityCreater.createGlobalException(ex.getErrorMessage(),
	 * userMessage, ex.getErrorCode()), HttpStatus.INTERNAL_SERVER_ERROR); }
	 */

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleRequestFormatMethodArgumentNotValidException(MethodArgumentNotValidException ex, Locale locale) {
        Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) ->{
			
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleAccessDeniedException(AccessDeniedException ex, Locale locale) {
        LOGGER.error("Error message :{}, {}", ex.getMessage(), ex.getStackTrace());
        String userMessage = messageSource.getMessage("403", new Object[]{}, locale);
        return new ResponseEntity<>(
                globalExceptionEntityCreater.createGlobalException(ex.getMessage(), userMessage, "403"),
                HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(PersistenceException.class)
    public ResponseEntity<?> handleConstraintViolationException(PersistenceException ex) {
        LOGGER.error("Error message :{}, {}", ex.getMessage(), ex.getStackTrace());
        if (ex.getCause() instanceof ConstraintViolationException) {
            return new ResponseEntity<>(
                    globalExceptionEntityCreater.createGlobalException(ex.getMessage(), getMessage(ex.getCause().getCause().getMessage()), "500"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return handleException(ex);
        }
    }

    private String getMessage(String message){
        if(message.contains(ATTRIBUTE_CODE_ERROR)){
            return "Attribute with this attributeCode is already present.";
        }else{
            return message;
        }
    }
}