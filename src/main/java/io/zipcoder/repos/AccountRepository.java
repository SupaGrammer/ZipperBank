package io.zipcoder.repos;

import io.zipcoder.DAOs.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

    @Query(value = "SELECT a.* " +
            "FROM Customer c, Account a " +
            "WHERE c.CUSTOMER_ID = ?1 " +
            "AND a.CUSTOMER = c", nativeQuery = true)
    Iterable<Account> findAllAccountsByCustomer(Long customerId);
}
