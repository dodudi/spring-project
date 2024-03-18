package com.kwon.project.customer.api;

import com.kwon.project.customer.application.CustomerCreateService;
import com.kwon.project.customer.application.CustomerDeleteService;
import com.kwon.project.customer.application.CustomerSearchService;
import com.kwon.project.customer.application.CustomerUpdateService;
import com.kwon.project.customer.dto.request.CustomerCreateRequest;
import com.kwon.project.customer.dto.request.CustomerUpdateRequest;
import com.kwon.project.customer.dto.response.CustomerCreateResponse;
import com.kwon.project.customer.dto.response.CustomerSearchResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerCreateService customerCreateService;
    private final CustomerSearchService customerSearchService;
    private final CustomerUpdateService customerUpdateService;
    private final CustomerDeleteService customerDeleteService;

    @GetMapping
    public ResponseEntity<Set<CustomerSearchResponse>> searchMembers() {
        return ResponseEntity.ok(customerSearchService.searchAll());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerSearchResponse> searchMember(
            @PathVariable("customerId") Integer customerId
    ) {
        return ResponseEntity.ok(customerSearchService.search(customerId));
    }

    @PostMapping
    public ResponseEntity<CustomerCreateResponse> createMember(
            @Valid @RequestBody CustomerCreateRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerCreateService.create(request));
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Object> updateMember(
            @PathVariable("customerId") Integer customerId,
            @Valid @RequestBody CustomerUpdateRequest request
    ) {
        return ResponseEntity.ok(customerUpdateService.update(customerId, request));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Object> deleteMember(
            @PathVariable("customerId") Integer customerId
    ) {
        customerDeleteService.delete(customerId);
        return ResponseEntity.noContent()
                .build();
    }
}
