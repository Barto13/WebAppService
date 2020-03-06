package com.app.controller;

import java.util.*;

import com.app.entities.Service;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;


    @GetMapping("/services")
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    @GetMapping("/services/{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable(value = "id") Long serviceId)
            throws ResourceNotFoundException {
        Service service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Service not found for this id :: " + serviceId));
        return ResponseEntity.ok().body(service);
    }

    @PostMapping("/services")
    public Service createService(@Valid @RequestBody Service service) {
        return serviceRepository.save(service);
    }

    @PutMapping("/services/{id}")
    public ResponseEntity<Service> updateService(@PathVariable(value = "id") Long serviceId,
                                                 @Valid @RequestBody Service serviceDetails) throws ResourceNotFoundException {
        Service service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Service not found for this id :: " + serviceId));

        service.setServicename(serviceDetails.getServicename());
        service.setClientname(serviceDetails.getClientname());
        service.setClientsurname(serviceDetails.getClientsurname());
        service.setAddress(serviceDetails.getAddress());
        service.setCity(serviceDetails.getCity());
        service.setTelephone(serviceDetails.getTelephone());
        service.setStatus(serviceDetails.getStatus());
        final Service updatedService = serviceRepository.save(service);
        return ResponseEntity.ok(updatedService);
    }

    @DeleteMapping("/services/{id}")
    public Map<String, Boolean> deleteService(@PathVariable(value = "id") Long serviceId)
            throws ResourceNotFoundException {
        Service service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Service not found for this id :: " + serviceId));

        serviceRepository.delete(service);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
