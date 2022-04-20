package com.nagp.providermicroservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagp.providermicroservice.entity.ServiceProvider;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Integer>
{
	ServiceProvider findByServiceProviderName(String name);
	List<ServiceProvider> findByServiceId(int serviceId);
	List<ServiceProvider> findByPincode(int pincode);
	ServiceProvider deleteById(int id);
}
