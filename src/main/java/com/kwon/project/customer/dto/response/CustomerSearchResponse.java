package com.kwon.project.customer.dto.response;

import com.kwon.project.customer.domain.Customer;
import lombok.Getter;

import java.util.*;

@Getter
public class CustomerSearchResponse {
    private final String customerId;
    private final String username;
    private final String email;
    private final String profile;

    private CustomerSearchResponse(String customerId, String username, String email, String profile) {
        this.customerId = customerId;
        this.username = username;
        this.email = email;
        this.profile = profile;
    }

    public static Set<CustomerSearchResponse> of(List<Customer> customers) {
        Iterator<Customer> iterator = customers.iterator();
        Set<CustomerSearchResponse> results = new HashSet<>();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            CustomerSearchResponse response = of(customer);
            results.add(response);
        }

        return Collections.unmodifiableSet(results);
    }

    public static CustomerSearchResponse of(Customer customer) {
        return new CustomerSearchResponse(
                customer.getId().toString(),
                customer.getUsername(),
                customer.getEmail(),
                customer.getProfile()
        );
    }
}
