package com.mini.money.controller;


import com.mini.money.dto.myinfo.MyCustomerInfoResDTO;
import com.mini.money.service.impl.CustomerPassCheckServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerPassCheckController {
    CustomerPassCheckServiceImpl customerPassCheckService;

    @PostMapping("/mypage/check")
        public String checkPassword(@AuthenticationPrincipal MyCustomerInfoResDTO customerInfoResDTO, String password){
            customerPassCheckService.checkPassword(customerInfoResDTO.getPassword(), password);
            return customerInfoResDTO.getName();
        }
}
