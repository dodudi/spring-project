package com.kwon.project.customer.application;

import com.kwon.project.customer.domain.Customer;
import com.kwon.project.customer.dto.request.CustomerCreateRequest;
import com.kwon.project.customer.dto.response.CustomerCreateResponse;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@Transactional
@ExtendWith(MockitoExtension.class)
class CustomerCreateServiceTest {

    @InjectMocks
    private CustomerCreateService customerCreateService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    @DisplayName("회원 생성 성공 테스트")
    void createSuccess() {
        //given
        CustomerCreateRequest request = new CustomerCreateRequest("email", "username", "password", "profile");
        Customer customer = new Customer(1L, "email", "username", "password", "profile");

        //when
        given(customerRepository.save(any(Customer.class))).willReturn(customer);
        //then
        CustomerCreateResponse response = customerCreateService.create(request);
        Assertions.assertThat(response.getCustomerId()).isEqualTo("1");
    }
}