package com.phucduyen.database.service_implementors;

import com.phucduyen.database.enums.Role;
import com.phucduyen.database.models.entity_models.Account;
import com.phucduyen.database.models.entity_models.AccountStatus;
import com.phucduyen.database.models.request_models.AccountRequest;
import com.phucduyen.database.models.request_models.GuestRequest;
import com.phucduyen.database.repositories.AccountRepo;
import com.phucduyen.database.repositories.AccountStatusRepo;
import com.phucduyen.database.services.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService {

    private AccountRepo accountRepo;
    private AccountStatusRepo accountStatusRepo;
    @Override
    public boolean registerAccount(GuestRequest guestRequest) {
        Account account = accountRepo.findByPass(guestRequest.getPhoneNumb()).orElse(null);
        AccountStatus accountStatus = accountStatusRepo.findByStatus("available").orElse(null);
        if(account != null || accountStatus != null){
            return false;
        }

        account = Account.builder()
                .email(guestRequest.getEmail())
                .pass(guestRequest.getPhoneNumb())
                .role(Role.CUSTOMER)
                .status(accountStatus)
                .build();
        accountRepo.save(account);
        return true;
    }
}
