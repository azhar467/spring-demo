package com.azhar.springdemo.service;

import com.azhar.springdemo.exception.BankNotFoundException;
import com.azhar.springdemo.model.Bank;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BankService {
    void updateBank(Integer id, Bank updationBankDetails) throws BankNotFoundException;

    void deleteBank(Integer id);

    List<Bank> getAllBanks();

    Optional<Bank> getBankById(Integer id);

    void saveBankInfo(Bank bank);
}
