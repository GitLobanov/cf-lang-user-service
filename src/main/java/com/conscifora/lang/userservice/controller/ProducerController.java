package com.conscifora.lang.userservice.controller;

import com.conscifora.lang.userservice.dto.*;
import com.conscifora.lang.userservice.service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.*;
import java.util.concurrent.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProducerController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<String> createProducer(@RequestBody CreateProductDto createProductDto) throws ExecutionException, InterruptedException, ExportException {
        String productId = productService.createProduct(createProductDto)
                .orElseThrow(() -> new RuntimeException("Error creating product"));

            return ResponseEntity.status(HttpStatus.CREATED).body(productId);
    }

}
