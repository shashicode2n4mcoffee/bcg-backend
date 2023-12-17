package com.bcg.backend.controller;

import com.bcg.backend.model.ConnectionRequest;
import com.bcg.backend.service.ConnectionRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/connection-requests")
@RequiredArgsConstructor
public class ConnectionRequestDataController {

    private final ConnectionRequestService connectionRequestService;

    @GetMapping
    public ResponseEntity<List<ConnectionRequest>> getAllConnectionRequests() {
        List<ConnectionRequest> connectionRequests = connectionRequestService.getAllConnectionRequests();
        return new ResponseEntity<>(connectionRequests, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConnectionRequest> getConnectionRequestById(@PathVariable Long id) {
        ConnectionRequest connectionRequest = connectionRequestService.getConnectionRequestById(id);
        return new ResponseEntity<>(connectionRequest, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ConnectionRequest> createConnectionRequest(@RequestBody ConnectionRequest request) {
        ConnectionRequest createdRequest = connectionRequestService.createConnectionRequest(request);
        return new ResponseEntity<>(createdRequest, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConnectionRequest> updateConnectionRequest(
            @PathVariable Long id,
            @RequestBody ConnectionRequest request
    ) {
        ConnectionRequest updatedRequest = connectionRequestService.updateConnectionRequest(id, request);
        return new ResponseEntity<>(updatedRequest, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConnectionRequest(@PathVariable Long id) {
        connectionRequestService.deleteConnectionRequest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
