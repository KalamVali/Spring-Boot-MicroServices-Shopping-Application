package com.customer.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	public List<Customer> findByCompanyId(Integer id);
}
