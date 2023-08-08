package com.example.employeeapp.service;

import com.example.employeeapp.entity.Employee;
import com.example.employeeapp.repository.EmployeeRepo;
import com.example.employeeapp.response.AddressResponse;
import com.example.employeeapp.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;

    }
    public EmployeeResponse getEmployeeById(int theId){

        //addressResponse -> set data by making a rest api call
        AddressResponse addressResponse = new AddressResponse();

        //convert employee -->employee response
        Employee employee = employeeRepo.findById(theId).get();

        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);

        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;
    }
}
