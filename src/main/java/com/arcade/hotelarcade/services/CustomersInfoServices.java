package com.arcade.hotelarcade.services;

import com.arcade.hotelarcade.entity.CustomerInfoEntity;

import java.util.List;

public interface CustomersInfoServices {
    
    List<CustomerInfoEntity> findAll();
    CustomerInfoEntity findById(Long id);

    List<CustomerInfoEntity> findByLastName(String lastName);

    CustomerInfoEntity findByNationalId(String nationalId);

    void save(CustomerInfoEntity customerInfoEntity);

    void delete(Long id);

    void update(CustomerInfoEntity customerInfoEntity, Long id);
}
