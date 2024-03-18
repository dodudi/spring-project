package com.kwon.project.customer.application;

import com.kwon.project.customer.domain.Customer;
import com.kwon.project.customer.dto.request.CustomerCreateRequest;
import com.kwon.project.customer.dto.response.CustomerCreateResponse;
import com.kwon.project.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerCreateService {
    private final CustomerRepository customerRepository;

    @Transactional
    public CustomerCreateResponse create(CustomerCreateRequest request) {
        Customer customer = new Customer(
                request.getEmail(), request.getUsername(), request.getPassword(), request.getProfile()
        );

        Customer result = customerRepository.save(customer);
        return CustomerCreateResponse.of(result);
    }
}
