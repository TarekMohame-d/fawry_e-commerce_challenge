package Implementation.Repository;

import Contract.Repository.IAddressRepository;
import Entities.Address;
import Helper.InMemoryDatabase;
import Helper.TableName;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AddressRepository extends GenericRepository<Address> implements IAddressRepository {
    private final List<Address> table;

    public AddressRepository() {
        super(TableName.ADDRESSES);
        this.table = InMemoryDatabase.getInstance().getTable(TableName.ADDRESSES);
    }

    @Override
    public Optional<Address> getAddressDetails(UUID id) {
        return Optional.empty();
    }
}
