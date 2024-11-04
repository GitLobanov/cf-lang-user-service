package com.conscifora.lang.userservice.dto;

import lombok.*;

@Builder
public record CreateProductDto (
        String title, String price, Integer quantity
) {
}
