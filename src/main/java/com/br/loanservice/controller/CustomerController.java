package com.br.loanservice.controller;

import com.br.loanservice.dto.response.CustomerLoanResponse;
import com.br.loanservice.dto.response.CustomerResponse;
import com.br.loanservice.dto.resquest.CustomerRequest;
import com.br.loanservice.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @Operation(summary = "Create customer", description = "Save a customer in the database")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Successfully created"),
                    @ApiResponse(responseCode = "403", description = "You do not have permission to access this resource."),
                    @ApiResponse(responseCode = "400", description = "An exception was generated")
            }
    )
    @PostMapping("/create-customer")
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        return new ResponseEntity<>(customerService.createCustomer(customerRequest), HttpStatus.CREATED);
    }

    @Operation(summary = "List customer loan", description = "Returns a list")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Returns successfully!"),
                    @ApiResponse(responseCode = "403", description = "You do not have permission to access this resource."),
                    @ApiResponse(responseCode = "400", description = "An exception was generated")
            }
    )
    @GetMapping("/list-customer-loan")
    public ResponseEntity<List<CustomerLoanResponse>> listCustomerLoan(@RequestParam(required = false) Integer idCustomer) {
        return new ResponseEntity<>(customerService.listCustomerLoan(idCustomer), HttpStatus.OK);
    }
}
