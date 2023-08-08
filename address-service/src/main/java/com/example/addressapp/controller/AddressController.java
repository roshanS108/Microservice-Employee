package com.example.addressapp.controller;

import com.example.addressapp.response.AddressResponse;
import com.example.addressapp.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }
    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponse>getAddressByEmployeeId(@PathVariable("employeeId") int id){
        AddressResponse addressResponse = null;
        addressResponse = addressService.findEmployeeByEmployeeId(id);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);

    }
}
