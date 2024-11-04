package com.conscifora.lang.userservice.service;

import com.conscifora.lang.userservice.dto.*;
import com.conscifora.lang.userservice.service.event.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.concurrent.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final KafkaTemplate<String, ProductCreateEvent> kafkaTemplate;

    @Override
    public String createProduct(CreateProductDto createProductDto) {
        // TODO save to DB

        String productId = UUID.randomUUID().toString();

        ProductCreateEvent productCreateEvent = ProductCreateEvent.builder()
                .price(createProductDto.price())
                .quantity(createProductDto.quantity())
                .title(createProductDto.title())
                .productId(productId)
                .build();

        // Async request

//        CompletableFuture<SendResult<String, ProductCreateEvent>> future = kafkaTemplate.send("product-created-events-topic", productId, productCreateEvent);
//        future.whenComplete(
//                (result, throwable) -> {
//                    if (throwable != null) {
//                        log.error("Failed to send message {}", throwable.getMessage());
//                    } else {
//                        log.info("Successfully sent message {}", result.getRecordMetadata());
//                    }
//                }
//        );

        // join is making request in sync
        // future.join();

        try {
            SendResult<String, ProductCreateEvent> future = kafkaTemplate.send("product-created-events-topic", productId, productCreateEvent).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        log.info("Return: {}", productId);
        return productId;
    }
}
