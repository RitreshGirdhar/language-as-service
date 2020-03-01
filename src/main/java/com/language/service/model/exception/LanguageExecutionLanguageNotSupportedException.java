package com.language.service.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Language Not Supported")
public class LanguageExecutionLanguageNotSupportedException extends LanguageExecutionException {

}
