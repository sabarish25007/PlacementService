package com.mvit.placementservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PlacementController {

	@Autowired
	private PlacementService service;
	
	@PostMapping("placement/service")
	public void add(@RequestBody Placement cust)
	{
		service.insertRecord(cust);
	}
	
	
	@GetMapping("/placementservice")
	public List<Placement> ShowAll()
	{
		return service.getAllRecords();
	}

	
	@GetMapping("/placementservice/{id}")
	public Placement getPlacementById(@PathVariable Integer id)
	{
		return service.getPlacementById(id);
	}
	
	@DeleteMapping("/placementservice/{id}")
	public void deletePlacement(@PathVariable Integer id)
	{
		service.deletePlacement(id);
	}
	
	@PutMapping("/placementservice/{id}")
	public ResponseEntity<String> updatePlacement(@PathVariable Integer id,@RequestBody Placement updatedPlacement)
	{
		service.updatePlacement(id,updatedPlacement);
		return ResponseEntity.ok("Placement updated Successfully");
	}
}
