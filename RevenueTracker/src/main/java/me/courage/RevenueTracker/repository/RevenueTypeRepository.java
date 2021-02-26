package me.courage.RevenueTracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import me.courage.RevenueTracker.model.RevenueType;

public interface RevenueTypeRepository extends JpaRepository<RevenueType, Integer> {

	public List<RevenueType> findByName(String name);
	public Optional<RevenueType> findById(Integer id);
	

}
