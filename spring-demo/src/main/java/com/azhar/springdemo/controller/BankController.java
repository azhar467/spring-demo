package com.azhar.springdemo.controller;

import com.azhar.springdemo.model.Bank;
import com.azhar.springdemo.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    BankService bankService;

    @PostMapping("/saveBank")
    public void saveBank(@RequestBody Bank bank){
        bankService.saveBankInfo(bank);
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/bankDetails/{id}"})
    public Optional<Bank> getBankDetails(@PathVariable("id") Integer id){
        return bankService.getBankById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/banks"})
    public List<Bank> getBankDetails(){
        return bankService.getAllBanks();
    }

}
