package com.example.demo.sec;

import lombok.Builder;
import lombok.Getter;
// https://do-study.tistory.com/106
@Builder
@Getter
public class JwtAuthenticationToken implements AuthenticationToken {
    private String token;
}
