package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.DuplicateEmailException;
import com.example.demo.model.Vendor;
import com.example.demo.repository.VendorRepository;

@Service
public class VendorService {
	@Autowired
	VendorRepository vendorRepo;

	public Vendor addVendor(Vendor vendor) {
		if (vendorRepo.existsByEmail(vendor.getEmail())) {
			throw new DuplicateEmailException("Email already exists. Please choose different email!");
		}
		return vendorRepo.save(vendor);
	}

	public List<Vendor> getVendors() {
		return vendorRepo.findAll();
	}
}
