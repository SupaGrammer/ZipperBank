package io.zipcoder.repos;

import io.zipcoder.DAOs.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
}
