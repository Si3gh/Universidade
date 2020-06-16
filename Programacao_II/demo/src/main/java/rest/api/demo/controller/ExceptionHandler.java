package rest.api.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import rest.api.demo.exception.PessoaNotFoundException;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(PessoaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handler(PessoaNotFoundException exception){
    }
}
