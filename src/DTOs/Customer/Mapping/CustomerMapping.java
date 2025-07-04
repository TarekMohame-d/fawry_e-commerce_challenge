package DTOs.Customer.Mapping;

import DTOs.Customer.CustomerRegisterRequestDto;
import Entities.Customer;

public class CustomerMapping {
    public static Customer toEntity(CustomerRegisterRequestDto dto) {
        return new Customer(dto.firstName,
                dto.lastName,
                dto.email,
                dto.password,
                dto.phone);
    }

//    public static CustomerDto toDto(Customer entity) {
//        // convert entity to DTO
//    }
}
