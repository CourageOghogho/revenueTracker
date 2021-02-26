package me.courage.RevenueTracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.courage.RevenueTracker.model.RevenueType;
import me.courage.RevenueTracker.repository.RevenueTypeRepository;
@Service
public class RevenueTypeService {
	@Autowired
	private RevenueTypeRepository revenueTypeRepository;
	
	public RevenueType save(RevenueType newTax) {
		return revenueTypeRepository.save(newTax);
	}
	
	public List<RevenueType> findByName(String name) {
		return revenueTypeRepository.findByName(name);
	}
	
	public List<RevenueType> findall() {
		return revenueTypeRepository.findAll();
	}
	
	public Optional<RevenueType> findById(Integer id) {
		return revenueTypeRepository.findById(id);
	}


}
