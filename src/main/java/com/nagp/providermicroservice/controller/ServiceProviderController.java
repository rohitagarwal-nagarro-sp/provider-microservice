package com.nagp.providermicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.providermicroservice.entity.ServiceProvider;
import com.nagp.providermicroservice.service.ServiceProviderService;

@RestController	
@RequestMapping("/provider")
public class ServiceProviderController {
	
	@Autowired
	ServiceProviderService providerService;
	
	@GetMapping("/getAllServiceProvider")
	public ResponseEntity<List<ServiceProvider>> getAllUser() 
	{
		List<ServiceProvider> list=providerService.findAll();
		return new ResponseEntity<List<ServiceProvider>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/getServiceProviderByName")
	public ResponseEntity<ServiceProvider> findByServiceProviderName(@RequestParam("name") String name)
	{
		return new ResponseEntity<ServiceProvider>(providerService.findByServiceProviderName(name), new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/getServiceProviderByServiceId")
	public ResponseEntity<List<ServiceProvider>> findByServiceId(@RequestParam("serviceId") int serviceId)
	{
		return new ResponseEntity<List<ServiceProvider>>(providerService.findByServiceId(serviceId), new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/getServiceProviderByPincode")
	public ResponseEntity<List<ServiceProvider>> findByPincode(@RequestParam("pincode") int pincode)
	{
		return new ResponseEntity<List<ServiceProvider>>(providerService.findByPincode(pincode), new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/addServiceProvider")
	public ResponseEntity<ServiceProvider> addUser(@RequestBody ServiceProvider user)
	{
		ServiceProvider provider = providerService.save(user);
		if(provider == null) {
			return new ResponseEntity<ServiceProvider>(provider,new HttpHeaders(),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ServiceProvider>(provider,new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping("/editServiceProvider")
	public ResponseEntity<ServiceProvider> editUser(@RequestBody ServiceProvider newUser, @RequestParam("id") int id)
	{
		ServiceProvider provider = providerService.findById(id).orElse(null);
		if(provider == null) {
			return new ResponseEntity<ServiceProvider>(providerService.save(newUser),new HttpHeaders(),HttpStatus.OK);
		}
		else {
			newUser.setServiceProviderId(id);
			return new ResponseEntity<ServiceProvider>(providerService.save(newUser),new HttpHeaders(),HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/deleteUser")
	public ResponseEntity<ServiceProvider> deleteUser(@RequestParam("id")  int id){
		return new ResponseEntity<ServiceProvider>(providerService.deleteById(id),new HttpHeaders(),HttpStatus.OK);
	}
}
