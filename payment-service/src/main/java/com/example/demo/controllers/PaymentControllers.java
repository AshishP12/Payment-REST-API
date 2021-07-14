package com.example.demo.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Payment;
import com.example.demo.services.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameters;

@RestController
public class PaymentControllers {

	@Autowired
	private PaymentService service;
	
	@GetMapping(path="/payments")
	public List<Payment> getAll(){
		
		return this.service.getAll();
		
	}
	
	@GetMapping(path="/payments/{id}")
	public Payment getById(@PathVariable("id") int id){
		
		return this.service.getById(id);
		
	}
   
//	@Operation(description ="This method fetches the Payment Details by transaction Id",    parameters = @P(example = "101 or 102"))
@PostMapping(path="/payments")	
	public ResponseEntity<Payment> add(@RequestBody Payment entity) {
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(this.service.add(entity));
		
	}


@PutMapping(path="/payments")	
public Payment update(@RequestBody Payment entity) {
	
	return this.service.add(entity);
	
}


@DeleteMapping(path="/payments")	
public Payment remove(@RequestBody Payment entity) {
	
	return this.service.remove(entity);
	
}


@GetMapping(path="/payments/srch/desc/{description}")
public List<Payment> getByDescription(@PathVariable("description") String description){
	
	return this.service.getByDescription(description);
}


@GetMapping(path="/payments/srch/amount/{amount}")
public List<Payment> getByAmountGreaterThan(@PathVariable("amount") double amount){
	
	return this.service.getByAmountGreaterThan(amount);
}

@GetMapping(path="/payments/srch/{id}/{amount}")
public ResponseEntity<String> updateAmount(@PathVariable("id") int id, @PathVariable("amount") double amount)
{
	int rowsUpdated=this.service.updateAmount(id,amount);
return ResponseEntity.ok().body(rowsUpdated + "Rows updated");
	


}}
