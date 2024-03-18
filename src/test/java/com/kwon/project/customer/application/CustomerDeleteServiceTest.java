package com.kwon.project.customer.application;

import com.kwon.project.customer.domain.Customer;
import com.kwon.project.customer.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@Transactional
@ExtendWith(MockitoExtension.class)
class CustomerDeleteServiceTest {
    @InjectMocks
    private CustomerDeleteService customerDeleteService;
    @InjectMocks
    private CustomerSearchService customerSearchService;

    @Mock
    private CustomerRepository customerRepository;


    @Test
    @DisplayName("회원 삭제 성공 케이스")
    void delete() {
        //given
        Customer customer = new Customer(1L, "email", "username", "password", "profile");

        //when
        given(customerRepository.findById(1L)).willReturn(Optional.of(customer));

        //then
        customerDeleteService.delete(1);
    }
}