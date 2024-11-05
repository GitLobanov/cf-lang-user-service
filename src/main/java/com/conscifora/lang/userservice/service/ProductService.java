package com.conscifora.lang.userservice.service;

import com.conscifora.lang.userservice.dto.*;

import java.rmi.server.*;
import java.util.*;
import java.util.concurrent.*;

public interface ProductService {

    Optional<String> createProduct(CreateProductDto createProductDto) throws ExportException, InterruptedException, ExecutionException;

}
