package com.azhar.springdemo.controller;

import com.azhar.springdemo.exception.BankNotFoundException;
import com.azhar.springdemo.model.Bank;
import com.azhar.springdemo.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/bank", produces = "application/json")
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
    public Optional<Bank> getBankDetails(@PathVariable("id") Integer id){
        return bankService.getBankById(id);
    }

    @GetMapping({"/banks"})
    @ResponseStatus(HttpStatus.OK)
    public CompletableFuture<List<Bank>> getAllBanksDetails(){
        return bankService.getAllBanks();
    }

    @DeleteMapping({"/bankDetails/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBank(@PathVariable("id") Integer id){
        bankService.deleteBank(id);
    }

    @PutMapping({"/bankDetails/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBank(@PathVariable Integer id,@RequestBody Bank updatingBankDetails) throws BankNotFoundException {
        bankService.updateBank(id,updatingBankDetails);
    }

}
