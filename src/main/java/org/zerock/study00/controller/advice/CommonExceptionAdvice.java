package org.zerock.study00.controller.advice;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ui.Model;

@ControllerAdvice
@Log4j2

public class CommonExceptionAdvice {

    @ExceptionHandler(NumberFormatException.class)
    public String handleNumberFormatException(Exception exception, Model model) {

        log.info("==================================");
        log.info(exception.getMessage());

        model.addAttribute("msg", "Number Check");

        return "error_page";
    }
}
