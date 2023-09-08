package com.sample.paymentservice.controllers;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.paymentservice.entities.Payment;
import com.sample.paymentservice.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
	private PaymentService paymentService;
    
    @PostMapping("/payamount")
    public ResponseEntity<?> paymentProcessing(@RequestBody Payment payment){
    	//boolean value has to be generated randomly (true/false)
    	System.out.println("In payment Processing...");
    	boolean paymentStatus=new Random().nextBoolean();
    	if(paymentStatus)
    		payment.setPaymentStatus("Success");
    	else
    		payment.setPaymentStatus("Failure");
     Payment savedPayment=	paymentService.savePayment(payment);
     return new ResponseEntity<Payment>(savedPayment,HttpStatus.OK);
    }
    @GetMapping("/{paymentid}")
    public ResponseEntity<?> getPaymentDetails(@PathVariable int paymentid){
    	Payment payment=paymentService.getPayment(paymentid);
    	if(payment==null)
    		return new ResponseEntity<String>("Payment details doesnt exists",HttpStatus.OK);
    	else
    	return new ResponseEntity<Payment>(payment,HttpStatus.OK);
    }
}




