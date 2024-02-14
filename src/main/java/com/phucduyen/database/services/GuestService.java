package com.phucduyen.database.services;

import com.phucduyen.database.models.entity_models.Account;

public interface GuestService {
    Account registerAccount(String email, String phoneNumb);
}

