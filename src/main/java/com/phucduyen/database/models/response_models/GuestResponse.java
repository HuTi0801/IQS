package com.phucduyen.database.models.response_models;

import com.phucduyen.database.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GuestResponse {
    private String phoneNumb;
    private String email;
}
