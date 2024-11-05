package com.conscifora.lang.userservice.dto;


import java.time.*;

public record ErrorMessage(
        LocalDateTime timestamp,
        String message
) {
}
