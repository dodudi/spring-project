package com.kwon.project.customer.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomerUpdateRequest {
    @NotEmpty(message = "이메일은 필수값 입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "이메일 주소 양식을 확인해주세요")
    private String email;
    @NotEmpty(message = "이름은 필수값 입니다.")
    private String username;
    @NotEmpty(message = "비밀번호는 필수값 입니다.")
    private String password;
    private String profile;
}
