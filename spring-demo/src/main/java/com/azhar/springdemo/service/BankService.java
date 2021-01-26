package com.azhar.springdemo.service;

import com.azhar.springdemo.model.Bank;
import com.azhar.springdemo.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public void saveBankInfo(Bank bank){
        bankRepository.save(bank);
    }

    public Optional<Bank> getBankById(Integer id){
        return bankRepository.findById(id);
    }

    public List<Bank> getAllBanks(){
        return bankRepository.findAll();
    }

    public void deleteBank(Integer id){
        bankRepository.deleteById(id);
    }

}
