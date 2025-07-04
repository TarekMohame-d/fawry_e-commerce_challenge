package Contract.Repository;

import Entities.Address;

import java.util.Optional;
import java.util.UUID;

public interface IAddressRepository extends IGenericRepository<Address>{
    Optional<Address> getAddressDetails(UUID id);
}
