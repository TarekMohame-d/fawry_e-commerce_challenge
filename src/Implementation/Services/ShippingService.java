package Implementation.Services;

import Contract.Services.IShippingService;
import Entities.Common.ICanBeShipped;

import java.util.List;

public class ShippingService implements IShippingService {
    @Override
    public void shipOrder(List<ICanBeShipped> orderItems) {
        // TODO: Shipping logic
    }
}
