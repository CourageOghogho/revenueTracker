package me.courage.RevenueTracker.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.courage.RevenueTracker.error.RevenueTypeErrorResponse;
import me.courage.RevenueTracker.error.RevenueTypeNotFoundException;
import me.courage.RevenueTracker.model.RevenueType;
import me.courage.RevenueTracker.service.RevenueTypeService;

@RestController
@RequestMapping("/revenues")
public class RevenueTypeController {
	List<RevenueType> revenues;
	@Autowired
	RevenueTypeService revenueTypeService;
	
	@PostMapping("/new")
	public RevenueType newTax(@RequestBody RevenueType newTax) {
		return revenueTypeService.save(newTax);
	}
	
	@GetMapping("/all")
	@ResponseBody
	public List<RevenueType> getAllRevnueType() {
		
		return revenueTypeService.findall();
	}
	
	@GetMapping("/tax/{id}")
	public RevenueType getRevnueType(@PathVariable Integer id) {
		
		return revenueTypeService.findById(id)
				.orElseThrow(() -> new RevenueTypeNotFoundException("Revenue type not found"));
	}
	

	@PostConstruct
	public void trying() {
		revenues=new ArrayList<>();
		revenues.add(new RevenueType("PAYE","Pay As You Earn",3.4f));
		revenues.add(new RevenueType("Personal","Personal Tax",3.5f));
		revenues.add(new RevenueType("Property","Property Tax",6.4f));
		for(RevenueType tax: revenues) {
			revenueTypeService.save(tax);
		}
		
	}
	
	
	@ExceptionHandler
	public ResponseEntity<RevenueTypeErrorResponse> handleException(RevenueTypeNotFoundException exc) {
		
		RevenueTypeErrorResponse error = new RevenueTypeErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	 }

	@ExceptionHandler
	public ResponseEntity<RevenueTypeErrorResponse> handleException(Exception exc) {
		
		RevenueTypeErrorResponse error = new RevenueTypeErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}	
	
}
