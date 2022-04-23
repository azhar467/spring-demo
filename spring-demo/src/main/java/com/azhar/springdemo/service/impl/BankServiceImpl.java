package com.azhar.springdemo.service.impl;

import com.azhar.springdemo.exception.BankNotFoundException;
import com.azhar.springdemo.model.Bank;
import com.azhar.springdemo.repository.BankRepository;
import com.azhar.springdemo.service.BankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<Bank> getBankById(Integer id){
        List<Bank> bankList = new ArrayList<>();
        bankList.add(bankRepository.findById(id).get());
        return bankList;
    }

    @Override
    public List<Bank> getAllBanks(){
        log.info("all banks "+bankRepository.findAll());
        return bankRepository.findAll();
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
