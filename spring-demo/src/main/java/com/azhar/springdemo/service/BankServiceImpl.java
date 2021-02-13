package com.azhar.springdemo.service;

import com.azhar.springdemo.exception.BankNotFoundException;
import com.azhar.springdemo.model.Bank;
import com.azhar.springdemo.repository.BankRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Bank> getAllBanks(){
        return bankRepository.findAll();
    }

    @Override
    public void deleteBank(Integer id){
        bankRepository.deleteById(id);
    }

    @Override
    public void updateBank(Integer id,Bank updationBankDetails) throws BankNotFoundException {
        if (bankRepository.existsById(id)){
            bankRepository.save(updationBankDetails);
        } else {
            throw new BankNotFoundException(id);
        }
    }

}
