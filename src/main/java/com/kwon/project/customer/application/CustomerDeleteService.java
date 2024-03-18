package com.kwon.project.customer.application;

import com.kwon.project.customer.domain.Customer;
import com.kwon.project.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerDeleteService {
    private final CustomerRepository customerRepository;

    @Transactional
    public void delete(Integer customerId) {
        final long id = customerId;
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        customerRepository.delete(customer);
    }
}
