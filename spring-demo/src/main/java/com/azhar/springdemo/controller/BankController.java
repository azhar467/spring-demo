package com.azhar.springdemo.controller;

import com.azhar.springdemo.exception.BankNotFoundException;
import com.azhar.springdemo.model.Bank;
import com.azhar.springdemo.service.BankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
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
    public List<Bank> getBankDetailsByID(@PathVariable("id") Optional<Integer> id){
        return bankService.getBankById(id.get());
    }

    @GetMapping(value={"/bankDetails"})
    @ResponseStatus(HttpStatus.OK)
    public List<Bank> getAllBankDetails(){
        log.info("all bank details "+bankService.getAllBanks());
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
