package com.edusol.billing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edusol.billing.model.Products;
import com.edusol.billing.service.BillingService;

@RestController
@RequestMapping("/billing")
public class BillingController {
	
	@Autowired
	
	BillingService billingService;
	
	@GetMapping("get-products")
	public ResponseEntity<Products[]>getProducts() {
		return billingService.getProducts();
	}
	
	@GetMapping("/get-products-by-id")
	public ResponseEntity<Products>getProductsByid(@RequestParam int id){
		return billingService.getProductsByid(id);
	}
	@GetMapping("/get-products-by-category")
	public ResponseEntity<Products[]>getProductsByCategory(@RequestParam String category){
		return billingService.getProductsByCategory(category);
	}
	
	@PostMapping("/save-record")
	public String saveRecord(@RequestBody Products p) {
		return billingService.saveRecord(p);
	}
	@PutMapping("/update-record")
	public String updateRecord(@RequestBody Products p) {
		return billingService.updateRecord(p);
	}
	@DeleteMapping("/delete-record")
	public String deleteRecord(@RequestParam int id) {
		
	return billingService.deleteRecord(id);
	}
}
