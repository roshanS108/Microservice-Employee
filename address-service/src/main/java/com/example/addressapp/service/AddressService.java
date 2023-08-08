package com.example.addressapp.service;

import com.example.addressapp.entity.Address;
import com.example.addressapp.repo.AddressRepo;
import com.example.addressapp.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper modelMapper;

    public AddressService(AddressRepo addressRepo){
        this.addressRepo = addressRepo;
    }
    public AddressResponse findEmployeeByEmployeeId(int employeeId){

        Address address = addressRepo.findAddressByEmployeeId(employeeId);
        AddressResponse addressResponse = modelMapper.map(address, AddressResponse.class);

        return addressResponse;
    }

}
