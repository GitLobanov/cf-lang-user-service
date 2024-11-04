package com.conscifora.lang.userservice.service;

import com.conscifora.lang.userservice.dto.*;

import java.rmi.server.*;

public interface ProductService {

    String createProduct(CreateProductDto createProductDto) throws ExportException, InterruptedException;

}
