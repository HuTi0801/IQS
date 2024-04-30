package com.phucduyen.database.models.request_models;

import com.phucduyen.database.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GuestRequest {
    private String phoneNumb;
    private String email;
}
