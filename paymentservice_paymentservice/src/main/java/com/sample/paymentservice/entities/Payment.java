package com.sample.paymentservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int paymentid;
private int orderid;
private double amount;
private String paymentStatus;
}
