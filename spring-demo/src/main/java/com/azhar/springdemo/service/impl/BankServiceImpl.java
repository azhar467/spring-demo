package com.azhar.springdemo.service.impl;

import com.azhar.springdemo.exception.BankNotFoundException;
import com.azhar.springdemo.model.Bank;
import com.azhar.springdemo.repository.BankRepository;
import com.azhar.springdemo.service.BankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public void saveBankInfo(Bank bank){
        bankRepository.save(bank);
    }

    @Override
    public Optional<Bank> getBankById(Integer id){
        return bankRepository.findById(id);
    }

    @Override
    @Async
    public CompletableFuture<List<Bank>> getAllBanks(){
        final List<Bank> banksList= bankRepository.findAll();
        return CompletableFuture.completedFuture(banksList);
    }

    @Override
    public void deleteBank(Integer id){
        bankRepository.deleteById(id);
    }

    @Override
    public void updateBank(Integer id,Bank updatingBankDetails) throws BankNotFoundException {
        if (bankRepository.existsById(id)){
            bankRepository.save(updatingBankDetails);
        } else {
            throw new BankNotFoundException(id);
        }
    }

}
