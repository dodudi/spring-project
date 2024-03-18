package com.kwon.project.customer.application;

import com.kwon.project.customer.domain.Customer;
import com.kwon.project.customer.dto.response.CustomerSearchResponse;
import com.kwon.project.customer.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@Transactional
@ExtendWith(MockitoExtension.class)
class CustomerSearchServiceTest {
    @InjectMocks
    private CustomerSearchService customerSearchService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    @DisplayName("회원 전체조회 성공 케이스")
    void searchAll() {
        //given
        List<Customer> listCustomers = List.of(
                new Customer(1L, "email", "username", "password", "profile"),
                new Customer(2L, "email", "username", "password", "profile")
        );

        //when
        given(customerRepository.findAll()).willReturn(listCustomers);

        //then
        Set<CustomerSearchResponse> response = customerSearchService.searchAll();
        Assertions.assertThat(response).hasSize(2);
    }

    @Test
    @DisplayName("회원 단일조회 성공 케이스")
    void search() {
        //given
        Customer customer = new Customer(1L, "email", "username", "password", "profile");

        //when
        given(customerRepository.findById(1L)).willReturn(Optional.of(customer));

        //then
        CustomerSearchResponse response = customerSearchService.search(1);
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getCustomerId()).isEqualTo(customer.getId().toString());
        Assertions.assertThat(response.getEmail()).isEqualTo(customer.getEmail());
    }
}