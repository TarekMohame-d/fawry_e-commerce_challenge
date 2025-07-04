package Contract.Repository;

import Entities.Customer;
import Entities.Product;

import java.util.*;

public interface ICustomerRepository extends IGenericRepository<Customer> {
    Optional<Customer> getCustomerDetails(UUID id);
}
