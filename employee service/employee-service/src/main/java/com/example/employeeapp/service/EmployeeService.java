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
    private final EmployeeRepo employeeRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo, ModelMapper modelMapper) {
        this.employeeRepo = employeeRepo;
        this.modelMapper = modelMapper;
    }
    public EmployeeResponse getEmployeeById(int theId){
        //convert employee -->employee response
        Employee employee = employeeRepo.findById(theId).get();
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
        AddressResponse addressResponse = null;

        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }
}
