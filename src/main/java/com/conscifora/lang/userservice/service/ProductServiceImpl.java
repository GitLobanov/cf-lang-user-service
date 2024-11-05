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
    public Optional<String> createProduct(CreateProductDto createProductDto) throws ExecutionException, InterruptedException {
        // TODO save to DB

        String productId = UUID.randomUUID().toString();

        ProductCreateEvent productCreateEvent = ProductCreateEvent.builder()
                .price(createProductDto.price())
                .quantity(createProductDto.quantity())
                .title(createProductDto.title())
                .productId(productId)
                .build();

        SendResult<String, ProductCreateEvent> result
                = kafkaTemplate.send("product-created-events-topic", productId, productCreateEvent).get();

        log.info("Topic: {}", result.getRecordMetadata().topic());
        log.info("Offset: {}", result.getRecordMetadata().offset());
        log.info("Partition: {}", result.getRecordMetadata().partition());
        log.info("Return: {}", productId);
        return Optional.of(productId);
    }
}
