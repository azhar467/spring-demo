package com.azhar.springdemo.controller;

import com.azhar.springdemo.exception.BankNotFoundException;
import com.azhar.springdemo.model.Bank;
import com.azhar.springdemo.service.BankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bank")
@Api(value = "Bank Resource REST End Point",description = "Shows bank Info")
public class BankController {

    @Autowired
    BankService bankService;

    @PostMapping("/saveBank")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBank(@RequestBody Bank bank){
        bankService.saveBankInfo(bank);
    }

    @GetMapping("/bankDetails/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Returns All Bank Details", notes = "Shows all bank details")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The request has succeeded"),
            @ApiResponse(code = 401, message = "The request requires user authentication"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The server has not found anything matching the Request-URI")})
    public Optional<Bank> getBankDetails(@PathVariable("id") Integer id){
        return bankService.getBankById(id);
    }

    @GetMapping({"/banks"})
    @ResponseStatus(HttpStatus.OK)
    public List<Bank> getAllBanksDetails(){
        return bankService.getAllBanks();
    }

    @DeleteMapping({"/bankDetails/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBank(@PathVariable("id") Integer id){
        bankService.deleteBank(id);
    }

    @PutMapping({"/bankDetails/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBank(@PathVariable Integer id,@RequestBody Bank updationBankDetails) throws BankNotFoundException {
        bankService.updateBank(id,updationBankDetails);
    }

}
