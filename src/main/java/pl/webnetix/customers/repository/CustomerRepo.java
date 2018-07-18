package pl.webnetix.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.webnetix.customers.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
