package com.kwon.project.customer.application;

import com.kwon.project.customer.domain.Customer;
import com.kwon.project.customer.dto.request.CustomerUpdateRequest;
import com.kwon.project.customer.dto.response.CustomerUpdateResponse;
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

import static org.mockito.BDDMockito.given;


@Transactional
@ExtendWith(MockitoExtension.class)
class CustomerUpdateServiceTest {
    @InjectMocks
    private CustomerUpdateService customerUpdateService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    @DisplayName("회원 업데이트 성공 케이스")
    void update() {
        //given
        CustomerUpdateRequest request = new CustomerUpdateRequest(
                "updateEmail",
                "updateName",
                "updatePassword",
                "updateProfile"
        );

        Customer customer = new Customer(1L, "email", "username", "password", "profile");

        //when
        given(customerRepository.findById(1L)).willReturn(Optional.of(customer));

        CustomerUpdateResponse response = customerUpdateService.update(1, request);
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getCustomerId()).isEqualTo("1");
        Assertions.assertThat(response.getEmail()).isEqualTo(request.getEmail());
        Assertions.assertThat(response.getUsername()).isEqualTo(request.getUsername());
        Assertions.assertThat(response.getProfile()).isEqualTo(request.getProfile());
    }
}