package Contract.Services;

import DTOs.Customer.BaseAuthRequestDto;
import DTOs.Customer.CustomerRegisterRequestDto;

import java.util.UUID;

public interface ICustomerServices {
    UUID registerCustomer(CustomerRegisterRequestDto dto);
    UUID loginCustomer(BaseAuthRequestDto dto);
}
