package DTOs.Customer;

public class CustomerRegisterRequestDto extends BaseAuthRequestDto {
    public String firstName;
    public String lastName;
    public String phone;

    public CustomerRegisterRequestDto() {}
    public CustomerRegisterRequestDto(String firstName,
                                      String lastName,
                                      String email,
                                      String password,
                                      String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
}
