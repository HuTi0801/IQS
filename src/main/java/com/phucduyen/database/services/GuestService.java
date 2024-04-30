package com.phucduyen.database.services;

import com.phucduyen.database.models.entity_models.Account;
import com.phucduyen.database.models.request_models.AccountRequest;
import com.phucduyen.database.models.request_models.GuestRequest;

public interface GuestService {
    boolean registerAccount(GuestRequest accountRequest);
}

