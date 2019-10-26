package guru.springframework.msscbrewery.services;

/*
 * Created by arunabhamidipati on 24/10/2019
 */

import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID custId);

    CustomerDto saveCustomer(CustomerDto customerDto);

    CustomerDto updateCustomer(CustomerDto customerDto);

    void deleteCustomerByObject(CustomerDto customerDto);
}
