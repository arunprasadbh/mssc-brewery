package guru.springframework.msscbrewery.services;

/*
 * Created by arunabhamidipati on 24/10/2019
 */

import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID custId) {
        log.info("Getting the customer by id");
        return CustomerDto.builder()
                .id(custId)
                .name("Aruna Bhamiipati")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        CustomerDto savedCustomer = CustomerDto.builder()
                                    .id(customerDto.getId())
                                    .name(customerDto.getName())
                                    .build();
        return savedCustomer;
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {
            CustomerDto updatedCustomer = CustomerDto.builder()
                                        .id(customerDto.getId())
                                        .name(customerDto.getName())
                                        .build();
            return updatedCustomer;
    }

    @Override
    public void deleteCustomerByObject(CustomerDto customerDto) {
        // todo
    }
}
