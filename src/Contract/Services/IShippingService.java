package Contract.Services;

import Entities.Common.ICanBeShipped;

import java.util.List;

public interface IShippingService {
    void shipOrder(List<ICanBeShipped> orderItems);
}
