package com.sample.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.paymentservice.entities.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
