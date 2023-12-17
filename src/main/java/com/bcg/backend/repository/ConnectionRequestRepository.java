package com.bcg.backend.repository;

import com.bcg.backend.model.ConnectionRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnectionRequestRepository extends JpaRepository<ConnectionRequest, Long> {

}