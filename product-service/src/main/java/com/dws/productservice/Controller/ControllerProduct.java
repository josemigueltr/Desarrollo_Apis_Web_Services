package com.dws.productservice.Controller;

import com.dws.productservice.dto.DtoProduct;
import com.dws.productservice.exceptionHandling.ApiException;
import com.dws.productservice.service.ServiceProductImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ControllerProduct {

    @Autowired
    ServiceProductImp serviceProduct;

    @GetMapping
    public ResponseEntity<Object> getProducts() throws Exception{
        try {
            return new ResponseEntity<>(serviceProduct.getProducts(), HttpStatus.OK);
        }catch(Exception e) {
            throw new ApiException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        }
    }

    @GetMapping("{codigo}")
    public ResponseEntity<Object> getProduct(@PathVariable("codigo") String codigo ) throws Exception{
        try {
            return new ResponseEntity<>(serviceProduct.getProduct(codigo), HttpStatus.OK);
        }catch(Exception e) {
            throw new ApiException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        }
    }

    @PostMapping
    public void createProduct(@RequestBody DtoProduct product) throws Exception{
        try {
                serviceProduct.createProduct(product);
        }catch(Exception e) {
            throw new ApiException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }
    }


    @DeleteMapping("/{codigo}")
    public void deleteProduct(@PathVariable String codigo) throws Exception{
        try {
            serviceProduct.deleteProduct(codigo);
        }catch(Exception e) {
            throw new ApiException(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        }
    }



}
