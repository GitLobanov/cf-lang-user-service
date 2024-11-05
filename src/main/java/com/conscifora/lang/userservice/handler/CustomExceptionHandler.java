package com.conscifora.lang.userservice.handler;

import com.conscifora.lang.userservice.dto.*;
import com.conscifora.lang.userservice.exception.*;
import org.springframework.web.bind.annotation.*;

import java.time.*;

public class CustomExceptionHandler {

    @ExceptionHandler(CreationException.class)
    private ErrorMessage creationException (CreationException creationException) {
        return new ErrorMessage(LocalDateTime.now(), creationException.getMessage());
    }

}
