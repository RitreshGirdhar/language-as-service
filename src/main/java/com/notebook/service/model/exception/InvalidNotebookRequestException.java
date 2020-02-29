package com.notebook.service.model.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid Request Format")
public class InvalidNotebookRequestException extends NotebookException {}
