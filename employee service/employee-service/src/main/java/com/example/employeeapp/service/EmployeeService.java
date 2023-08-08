package com.example.employeeapp.service;
import com.example.employeeapp.entity.Employee;
import com.example.employeeapp.repository.EmployeeRepo;
import com.example.employeeapp.response.AddressResponse;
import com.example.employeeapp.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {
    private EmployeeRepo employeeRepo;
    private ModelMapper modelMapper;

    private RestTemplate restTemplate;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo, ModelMapper modelMapper, RestTemplate restTemplate) {
        this.employeeRepo = employeeRepo;
        this.modelMapper = modelMapper;
        this.restTemplate = restTemplate;
    }
    public EmployeeResponse getEmployeeById(int theId){

        //convert employee -->employee response
        Employee employee = employeeRepo.findById(theId).get();
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
        //                                                                        url                                             response            uri variable
        AddressResponse addressResponse = restTemplate.getForObject("http://localhost:8081/address-app/api/address/{theId}",AddressResponse.class, theId);

        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;
    }
}
