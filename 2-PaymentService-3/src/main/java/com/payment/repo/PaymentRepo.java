package com.payment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.model.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer> {

}
