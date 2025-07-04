package Implementation.Services;

import Contract.Repository.ICustomerRepository;
import Contract.Services.ICartServices;
import Contract.Services.ICustomerServices;
import DTOs.Customer.BaseAuthRequestDto;
import DTOs.Customer.CustomerRegisterRequestDto;
import DTOs.Customer.Mapping.CustomerMapping;
import Entities.Customer;
import Implementation.Repository.CustomerRepository;

import java.util.UUID;

public class CustomerServices implements ICustomerServices {
    private ICustomerRepository customerRepository;
    private ICartServices cartService;

    public CustomerServices() {
        this.customerRepository = new CustomerRepository();
        this.cartService = new CartService();
    }

    @Override
    public UUID registerCustomer(CustomerRegisterRequestDto dto) {
        Customer customer = CustomerMapping.toEntity(dto);
        cartService.createCart(customer.getId());
        customerRepository.add(customer);
        return customer.getId();
    }

    @Override
    public UUID loginCustomer(BaseAuthRequestDto dto) {
        Customer customer = customerRepository
                .where(c -> c.getEmail().equals(dto.email)
                        && c.getPassword().equals(dto.password)).orElse(null);

        if (customer != null) {
            return customer.getId();
        }
        System.out.println("Invalid credentials.");
        return null;
    }
}
