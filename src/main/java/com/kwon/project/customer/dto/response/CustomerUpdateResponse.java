package com.kwon.project.customer.dto.response;

import com.kwon.project.customer.domain.Customer;
import lombok.Getter;

@Getter
public class CustomerUpdateResponse {
    private final String customerId;
    private final String username;
    private final String email;
    private final String profile;

    private CustomerUpdateResponse(String customerId, String username, String email, String profile) {
        this.customerId = customerId;
        this.username = username;
        this.email = email;
        this.profile = profile;
    }

    public static CustomerUpdateResponse of(Customer customer) {
        return new CustomerUpdateResponse(
                customer.getId().toString(),
                customer.getUsername(),
                customer.getEmail(),
                customer.getProfile()
        );
    }
}
