package com.bogguru.hep.digital.hep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bogguru.hep.digital.hep.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
