package com.phucduyen.database.service_implementors;

import com.phucduyen.database.models.entity_models.Account;
import com.phucduyen.database.services.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService {
    @Override
    public Account registerAccount(String email, String phoneNumb) {
        return null;
    }
}
