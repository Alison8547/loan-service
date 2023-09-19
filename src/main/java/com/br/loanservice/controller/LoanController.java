package com.br.loanservice.controller;

import com.br.loanservice.dto.response.LoanResponse;
import com.br.loanservice.dto.resquest.LoanRequest;
import com.br.loanservice.service.LoanService;
import com.br.loanservice.service.PdfService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Validated
@RestController
@RequestMapping
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;
    private final PdfService pdfService;


    @Operation(summary = "Open loan for the customer", description = "Save a loan in the database")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Successfully created"),
                    @ApiResponse(responseCode = "403", description = "You do not have permission to access this resource."),
                    @ApiResponse(responseCode = "400", description = "An exception was generated")
            }
    )
    @PostMapping("/open-loan/{idCustomer}")
    public ResponseEntity<LoanResponse> openLoan(@PathVariable(name = "idCustomer") Integer idCustomer, @RequestBody @Valid LoanRequest loanRequest) {
        return new ResponseEntity<>(loanService.openLoan(idCustomer, loanRequest), HttpStatus.CREATED);
    }

    @Operation(summary = "Generated pdf the loan", description = "Returns a pdf")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Returns successfully!"),
                    @ApiResponse(responseCode = "403", description = "You do not have permission to access this resource."),
                    @ApiResponse(responseCode = "400", description = "An exception was generated")
            }
    )
    @GetMapping("/generated-pdf-loan/{idLoan}")
    public ResponseEntity<Void> generatedPdfLoan(@PathVariable(name = "idLoan") Integer idLoan, HttpServletResponse httpServletResponse) throws IOException {
        pdfService.generatedPdfLoan(idLoan, httpServletResponse);
        return ResponseEntity.noContent().build();
    }
}
