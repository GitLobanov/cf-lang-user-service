package com.conscifora.lang.userservice.service.event;

import lombok.*;

@Builder
public record ProductCreateEvent (
        String productId, String title, String price, Integer quantity
) {

}
