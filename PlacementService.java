package com.mvit.placementservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class PlacementService {

	@Autowired
	private PlacementRepository repo;
	//Inserting the records to the table in database
	public void insertRecord(Placement cust)
	{
		repo.save(cust);
	}
	
	//Show all the records from the table in database
	public List<Placement> getAllRecords()
	{
		return repo.findAll();
	}
	
	//Show specific record from the table in database
	public Placement getPlacementById(Integer id)
	{
		return repo.findById(id).orElse(null);
	}
	
	//Deleting the specific record from the table in database
	public void deletePlacement(Integer id)
	{
		repo.deleteById(id);
	}
	
	//updating the existing record
	public void updatePlacement(Integer id,Placement updatePlacement)
	{
		Placement existingPlacement=repo.findById(id).orElse(null);
		if(existingPlacement!=null)
		{
			existingPlacement.setCid(updatePlacement.getCid());
			existingPlacement.setCname(updatePlacement.getCname());
			existingPlacement.setAddress(updatePlacement.getAddress());
			repo.save(existingPlacement);
		}
	}

	public Placement getStudentById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
