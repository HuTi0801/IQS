package com.phucduyen.database.controllers;

import com.phucduyen.database.models.response_models.AccountResponse;
import com.phucduyen.database.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/getall")
    @PreAuthorize("hasAuthority('admin:read')") //phân quyền
    //get all tất cả user trừ admin
    public ResponseEntity<List<AccountResponse>> getAll(){
        return ResponseEntity.ok().body(adminService.getAll());
    }

    @GetMapping("/viewAccount")
    @PreAuthorize("hasAuthority('admin:read')") //phân quyền
    //get all tất cả user trừ admin
    public ResponseEntity<List<AccountResponse>> viewAccount(@RequestParam Integer id){
        return ResponseEntity.ok().body(adminService.viewAccount(id));
    }
}
