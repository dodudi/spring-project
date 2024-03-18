package com.kwon.project.customer.application;

import com.kwon.project.customer.domain.Customer;
import com.kwon.project.customer.dto.response.CustomerSearchResponse;
import com.kwon.project.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomerSearchService {
    private final CustomerRepository customerRepository;

    public Set<CustomerSearchResponse> searchAll() {
        List<Customer> customers = customerRepository.findAll();
        return CustomerSearchResponse.of(customers);
    }

    public CustomerSearchResponse search(Integer customerId) {
        final long id = customerId;
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        return CustomerSearchResponse.of(customer);
    }
}
