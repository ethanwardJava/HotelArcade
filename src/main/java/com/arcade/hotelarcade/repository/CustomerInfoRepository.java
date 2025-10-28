package com.arcade.hotelarcade.repository;

import com.arcade.hotelarcade.entity.CustomerInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerInfoRepository extends JpaRepository<CustomerInfoEntity, Long> {
    List<CustomerInfoEntity> findByLastName(String lastName);
    CustomerInfoEntity findByNationalId(String nationalId);
}
