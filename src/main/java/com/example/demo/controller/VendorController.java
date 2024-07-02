package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/vendor")
@CrossOrigin("http://localhost:3000")
public class VendorController {
	@Autowired
	VendorService vendorService;
	@GetMapping("/getAllVendor")
	public List<Vendor> getVendors()
	{
		return vendorService.getVendors();
		
	}
	
	@PostMapping("/addVendor")
	public Vendor saveVendor(@RequestBody @Valid Vendor vendor)
	{
		return vendorService.addVendor(vendor);
	}
	
	

}
