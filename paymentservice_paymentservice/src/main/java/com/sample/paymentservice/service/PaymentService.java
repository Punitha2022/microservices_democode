package com.sample.paymentservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.paymentservice.entities.Payment;
import com.sample.paymentservice.repository.PaymentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PaymentService {
	@Autowired
private PaymentRepository paymentRepo;
	
	public Payment savePayment(Payment payment) {
	  return paymentRepo.save(payment);
	}

	public Payment getPayment(int paymentid) {
		Optional<Payment> payment=paymentRepo.findById(paymentid);
		if(payment.isPresent())
		return payment.get();
		else
			return null;
	}
}
