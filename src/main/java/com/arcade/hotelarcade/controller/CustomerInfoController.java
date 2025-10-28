package com.arcade.hotelarcade.controller;

import com.arcade.hotelarcade.entity.CustomerInfoEntity;
import com.arcade.hotelarcade.services.CustomersInfoServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/")
public class CustomerInfoController {

    private final CustomersInfoServices customersInfoServices;


    public CustomerInfoController(CustomersInfoServices customersInfoServices) {
        this.customersInfoServices = customersInfoServices;
    }

    // ================== RETURNS A LIST OF ALL CUSTOMERS (BOOKED OR NOT)=====================
    @GetMapping("/customers")
    public List<CustomerInfoEntity> findAll() {
        return customersInfoServices.findAll();
    }


    //==================== FETCHES ONE CUSTOMER BASED ON UNIQUE DB ID NUMBER =================
    @GetMapping("/customers/id/{id}")
    public CustomerInfoEntity findById(@PathVariable Long id) {
        return customersInfoServices.findById(id);
    }

    //=========================== FIND ALL CUSTOMERS WITH SAME NAME ==========================
    @GetMapping("/customers/lastname/{lastName}")
    public List<CustomerInfoEntity> findByLastName(@PathVariable String lastName) {
        return customersInfoServices.findByLastName(lastName);
    }

    //================= FETCHING THE CUSTOMER BY UNIQUE NATIONAL ID (STRING) ==================
    @GetMapping("/customers/nationalId/{nationalId}")
    public CustomerInfoEntity findByNationalId(@PathVariable String nationalId) {
        return customersInfoServices.findByNationalId(nationalId);
    }

    // =================== ADDING A NEW CUSTOMER ====================
    @PostMapping("/customer/new")
    public String addNewCustomer(@RequestBody CustomerInfoEntity customerInfoEntity) {
        customersInfoServices.save(customerInfoEntity);
        return "success";
    }

    // ======================REMOVING CUSTOMER BASED ON THE ID (DATA-BASE)===========================
    @DeleteMapping("/customers/remove/{id}")
    public String deleteCustomerById(@PathVariable Long id) {
        customersInfoServices.delete(id);
        return "success";
    }

    // ======================UPDATING A CUSTOMER==========================
    @PutMapping("customers/update/{id}")
    public String updateCustomerById(@RequestBody CustomerInfoEntity customerInfoEntity, @PathVariable Long id) {
        customersInfoServices.update(customerInfoEntity, id);
        return "Done";
    }

}
