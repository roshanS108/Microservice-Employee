package com.example.employeeapp.config;

import com.example.employeeapp.feignclient.AddressClient;
import com.example.employeeapp.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EmployeeAppConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public AddressClient addressClient(){
        return new AddressClient() {
            @Override
            public AddressResponse getAddressByEmployeeId(int theId) {
                return new AddressResponse();
            }
        };
    }




}
