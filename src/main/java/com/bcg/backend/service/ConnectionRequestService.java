package com.bcg.backend.service;

import com.bcg.backend.model.ConnectionRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ConnectionRequestService {
    List<ConnectionRequest> getAllConnectionRequests();

    ConnectionRequest getConnectionRequestById(Long id);

    ConnectionRequest createConnectionRequest(ConnectionRequest request);

    ConnectionRequest updateConnectionRequest(Long id, ConnectionRequest request);




    void deleteConnectionRequest(Long id);


}
