package com.phucduyen.database.repositories;

import ch.qos.logback.core.status.Status;
import com.phucduyen.database.models.entity_models.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountStatusRepo extends JpaRepository<AccountStatus, Integer> {
    Optional<AccountStatus> findByStatus(String status);
}
