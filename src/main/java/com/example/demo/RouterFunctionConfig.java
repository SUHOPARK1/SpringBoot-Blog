package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Handles requests for the application home page.
 */
@RestController
@CrossOrigin(origins="*")
public class RouterFunctionConfig {
/*
    @Bean
    public RouterFunction<?> index() {
        return route(GET("/hello"),
                request -> ok().body(just("Hello World !!"), String.class));
    }

*/
    @GetMapping("/test")
    public Map<?,?> hello(){
        System.out.println("React  Boot connect Success");
        Map<String,String> map = new HashMap<>();
        map.put("a","a");
        map.put("b","b");
        return map;
    }
}
