package com.arcade.hotelarcade.services;

import com.arcade.hotelarcade.controller.CustomerInfoController;
import com.arcade.hotelarcade.entity.CustomerInfoEntity;
import com.arcade.hotelarcade.error.ResourceNotFoundException;
import com.arcade.hotelarcade.repository.CustomerInfoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerInfoServicesImpl implements CustomersInfoServices {

    private final CustomerInfoRepository customerInfoRepository;

    public CustomerInfoServicesImpl(CustomerInfoRepository customerInfoRepository) {
        this.customerInfoRepository = customerInfoRepository;
    }

    /**
     * Retrieves all customer records from the database.
     *
     * @return a list of all {@link CustomerInfoEntity} instances, which may be empty if no customers exist
     * @apiNote This method is typically mapped to GET /customers in {@link CustomerInfoController}
     * @throws ResourceNotFoundException if nothing found
     */
    @Override
    public List<CustomerInfoEntity> findAll() {
        List<CustomerInfoEntity> customerInfoEntities = customerInfoRepository.findAll();
        if (customerInfoEntities.isEmpty()) {
            throw new ResourceNotFoundException("404 Not Found");
        } else return customerInfoEntities;

    }

    @Override
    public CustomerInfoEntity findById(Long id) {
        return customerInfoRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public List<CustomerInfoEntity> findByLastName(String lastName) {
        return customerInfoRepository.findByLastName(lastName);
    }

    @Override
    public CustomerInfoEntity findByNationalId(String nationalId) {
        return customerInfoRepository.findByNationalId(nationalId);
    }

    @Override
    public void save(CustomerInfoEntity customerInfoEntity) {
        customerInfoRepository.save(customerInfoEntity);
    }

    @Override
    public void delete(Long id) {
        customerInfoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(CustomerInfoEntity updatedCustomer, Long id) {
        CustomerInfoEntity existing = customerInfoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + id));

        // Only copy non-null and non-blank fields
        if (updatedCustomer.getFirstName() != null && !updatedCustomer.getFirstName().trim().isEmpty()) {
            existing.setFirstName(updatedCustomer.getFirstName().trim());
        }
        if (updatedCustomer.getLastName() != null && !updatedCustomer.getLastName().trim().isEmpty()) {
            existing.setLastName(updatedCustomer.getLastName().trim());
        }
        if (updatedCustomer.getNationalId() != null && !updatedCustomer.getNationalId().trim().isEmpty()) {
            existing.setNationalId(updatedCustomer.getNationalId().trim());
        }
        if (updatedCustomer.getEmail() != null && !updatedCustomer.getEmail().trim().isEmpty()) {
            existing.setEmail(updatedCustomer.getEmail().trim());
        }
        if (updatedCustomer.getAge() != null) {  // int can't be null, but wrapper Integer would be
            existing.setAge(updatedCustomer.getAge());
        }
        if (updatedCustomer.getAddress() != null && !updatedCustomer.getAddress().trim().isEmpty()) {
            existing.setAddress(updatedCustomer.getAddress().trim());
        }
        if (updatedCustomer.getCity() != null && !updatedCustomer.getCity().trim().isEmpty()) {
            existing.setCity(updatedCustomer.getCity().trim());
        }
        if (updatedCustomer.getState() != null && !updatedCustomer.getState().trim().isEmpty()) {
            existing.setState(updatedCustomer.getState().trim());
        }
        if (updatedCustomer.getCountry() != null && !updatedCustomer.getCountry().trim().isEmpty()) {
            existing.setCountry(updatedCustomer.getCountry().trim());
        }
        if (updatedCustomer.getPhone() != null && !updatedCustomer.getPhone().trim().isEmpty()) {
            existing.setPhone(updatedCustomer.getPhone().trim());
        }

        customerInfoRepository.save(existing);
    }
}
