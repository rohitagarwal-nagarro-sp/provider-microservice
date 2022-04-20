package com.nagp.providermicroservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagp.providermicroservice.entity.ServiceProvider;
import com.nagp.providermicroservice.repo.ServiceProviderRepository;

@Service
public class ServiceProviderService 
{
	@Autowired
	ServiceProviderRepository providerRepository;

	public List<ServiceProvider> findAll() {
		return providerRepository.findAll();
	}
	
	public ServiceProvider findByServiceProviderName(String name) {
		return providerRepository.findByServiceProviderName(name);
	}
	
	public List<ServiceProvider> findByServiceId(int serviceId) {
		return providerRepository.findByServiceId(serviceId);
	}
	
	public List<ServiceProvider> findByPincode(int pincode) {
		return providerRepository.findByPincode(pincode);
	}

	public ServiceProvider save(ServiceProvider serviceProvider) {
		return providerRepository.save(serviceProvider);
	}

	public Optional<ServiceProvider> findById(int id) {
		return providerRepository.findById(id);
	}

	public ServiceProvider deleteById(int id) {
		return providerRepository.deleteById(id);
	}
}
