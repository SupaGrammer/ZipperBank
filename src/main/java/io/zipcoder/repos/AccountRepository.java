package io.zipcoder.repos;

import io.zipcoder.DOAs.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
