package com.phucduyen.database.controllers;

import com.phucduyen.database.models.request_models.AccountRequest;
import com.phucduyen.database.models.request_models.GuestRequest;
import com.phucduyen.database.models.response_models.AccountResponse;
import com.phucduyen.database.models.response_models.GuestResponse;
import com.phucduyen.database.services.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping("/guest")
@RequiredArgsConstructor
public class GuestController {
    private final GuestService guestService;
    @PostMapping("/register_account")
    @PreAuthorize("hasAuthority('admin:create')")
    ResponseEntity<GuestResponse> testCreate(@RequestBody GuestRequest guestRequest){
        if(guestService.registerAccount(guestRequest))
            return ResponseEntity
                    .ok()
                    .body(
                            GuestResponse.builder()
                                    .phoneNumb(guestRequest.getPhoneNumb())
                                    .email(guestRequest.getEmail())
                                    .build()
                    );
        return ResponseEntity
                .badRequest()
                .body(null);
    }
}
