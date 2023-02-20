package com.mini.money.dto;

import com.mini.money.entity.Customer;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiModel;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@ApiModel(value = "로그인")
public class LogInReqDTO {

    private String email;
    private String password;

    public LogInReqDTO(Claims claims) {
        this.email = claims.get("email", String.class);
    }

    public Customer toEntity(){
        return Customer.builder()
                .email(this.email)
                .password(this.password)
                .build();
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        // ROLE_USER, ROLE_ADMIN 은 정해저 있는 네이밍임, getAuthorities() 이름도 같아야함
        // 만약 하나로 구분이 아니고 여러 개의 권한을 가져야 한다면, 아래와 닽이 쓸것
        //return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"),new SimpleGrantedAuthority("ROLE_ADMIN"));
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
