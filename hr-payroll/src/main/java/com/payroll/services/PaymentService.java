package com.payroll.services;

import org.springframework.stereotype.Service;

import com.payroll.model.Payment;

@Service
public class PaymentService {

	public Payment getPayment(Long workerId, int days) {
		return new Payment("Bob", 200.0, days);
	}
}
