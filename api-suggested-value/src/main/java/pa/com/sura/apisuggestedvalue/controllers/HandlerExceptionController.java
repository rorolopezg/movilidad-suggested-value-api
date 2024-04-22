package pa.com.sura.apisuggestedvalue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import pa.com.sura.apisuggestedvalue.errors.ApiError;

@ControllerAdvice
public class HandlerExceptionController {
    @Autowired
    private HttpServletRequest httpServletRequest;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> exceptionHandler(Exception ex) {
        ApiError error = new ApiError(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getLocalizedMessage(),
                ex,
                httpServletRequest.getRequestURI(),
                httpServletRequest.getHeader("x-trace-id"),
                "");
        return new ResponseEntity<ApiError>(error, HttpStatus.OK);
    }
}