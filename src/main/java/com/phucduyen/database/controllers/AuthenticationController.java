package com.phucduyen.database.controllers;

import com.phucduyen.database.models.request_models.TestRequest;
import com.phucduyen.database.models.response_models.TestResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @GetMapping("/test")
    public String testSecurity(){
        return "Hello";
    }

    @GetMapping("/test_version_1")
    public String testVer1(@RequestBody String data){
        //@RequestBody: vào thẳng Body kiếm 1 chuỗi String
        return "Hi " + data;
    }

    @GetMapping("/test_version_1_1")
    public String testVer1_1(@RequestBody TestRequest testRequest){
        return "Hi " + testRequest.getMessage();
    }

    @GetMapping("/test_version_1_2")
    public TestResponse testVer1_2(@RequestBody TestRequest testRequest){
        return TestResponse.builder()
                .message(testRequest.getMessage())
                .date(testRequest.getDate())
                .build();
    }

    @GetMapping("/test_version_2")
    public TestResponse testVer2(@RequestParam int message){
        return TestResponse.builder()
                .message(message)
                .date(null)
                .build();
    }

    @GetMapping("/hello/{message}")
    public TestResponse test_ver_3(@PathVariable int message){
        //@RequestBody: truyền dc dữ liệu object (dùng nhiều - che dấu thông tin - truyền dc file)
        //@RequestParam(name = "data"): ko truyền dc object, truyền từng con param
        //@RequestParam int message
        //@PathVariable int message <=> @GetMapping("/hello/{message}"): truyền thẳng trên đường dẫn, tên biến trùng tên
                                // trên dường link
        return TestResponse.builder()
                .message(message)
                .date(null)
                .build();
    }
}
