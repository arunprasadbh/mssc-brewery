package guru.springframework.msscbrewery.web.controllers;

/*
 * Created by arunabhamidipati on 24/10/2019
 */

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RequestMapping("/api/v1/customer")
@Controller
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{custId}"})
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("custId") UUID custId){
        log.info("The id {} is supplied...", custId.toString());
        return new ResponseEntity<> (customerService.getCustomerById(custId), HttpStatus.OK);

    }

    // For post, it saves the object
    // Return header with location and HttpStatus.CREATED
    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto){
        CustomerDto savedCustomer = customerService.saveCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "app/v1/customer/" + savedCustomer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.NO_CONTENT);
    }

    //For put it updates the object. Return HttpStatus.NO_CONTENT

    @PutMapping
    public ResponseEntity handlePut(@RequestBody CustomerDto customerDto) {
        CustomerDto newCustomer = customerService.updateCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/app/v1/customer/" + newCustomer.getId().toString());
        return new ResponseEntity(headers, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@RequestBody CustomerDto customerDto) {
        customerService.deleteCustomerByObject(customerDto);

    }

}
