package com.kwon.project.customer.application;

import com.kwon.project.customer.domain.Customer;
import com.kwon.project.customer.dto.request.CustomerCreateRequest;
import com.kwon.project.customer.dto.request.CustomerUpdateRequest;
import com.kwon.project.customer.dto.response.CustomerCreateResponse;
import com.kwon.project.customer.dto.response.CustomerUpdateResponse;
import com.kwon.project.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerUpdateService {
    private final CustomerRepository customerRepository;

    @Transactional
    public CustomerUpdateResponse update(Integer customerId, CustomerUpdateRequest request) {
        final long id = customerId;
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        customer.changeCustomer(request.getEmail(), request.getUsername(), request.getPassword(), request.getProfile());
        customerRepository.flush();

        return CustomerUpdateResponse.of(customer);
    }
}
