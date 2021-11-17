package com.payroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.payroll.model.Payment;
import com.payroll.model.Worker;

@Service
public class PaymentService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${hr-worker.host}")
	private String host;

	public Payment getPayment(Long workerId, int days) {
		
		Map<String, String> uriVariables = new HashMap<>();
		
		uriVariables.put("id", String.valueOf(workerId));
		
		Worker worker = restTemplate.getForObject(host + "/workers/{id}", Worker.class, uriVariables);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
