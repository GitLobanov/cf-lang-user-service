package com.conscifora.lang.userservice.controller;

import com.conscifora.lang.userservice.dto.*;
import com.conscifora.lang.userservice.service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class ProducerController {

    private final ProductService productService;

    @SneakyThrows
    @PostMapping
    public ResponseEntity<String> createProducer(@RequestBody CreateProductDto createProductDto) {
        String productId = productService.createProduct(createProductDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productId);
    }

}
