package com.bcg.backend.service;

import com.bcg.backend.model.ConnectionRequest;
import com.bcg.backend.repository.ConnectionRequestRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class ConnectionRequestServiceImpl implements ConnectionRequestService {

    @Autowired
    private ConnectionRequestRepository repository;

    @Override
    public List<ConnectionRequest> getAllConnectionRequests() {
        return repository.findAll();
    }

    @Override
    public ConnectionRequest getConnectionRequestById(Long id) {
        Optional<ConnectionRequest> optionalRequest = repository.findById(id);
        return optionalRequest.orElse(null);
    }

    @Override
    public ConnectionRequest createConnectionRequest(ConnectionRequest request) {
        ConnectionRequest savedRequest = repository.save(request);
        return savedRequest;
    }

    @Override
    public void deleteConnectionRequest(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ConnectionRequest updateConnectionRequest(Long id, ConnectionRequest request) {
        Optional<ConnectionRequest> optionalConnectionRequest = repository.findById(id);
        if (optionalConnectionRequest.isPresent()) {
            ConnectionRequest existingRequest = optionalConnectionRequest.get();
            updateConnectionRequestProperties(request, existingRequest);
            ConnectionRequest updatedRequest = repository.save(existingRequest);
            return updatedRequest;
        }
        return null; // Handle not found case
    }

    private void updateConnectionRequestProperties(ConnectionRequest source, ConnectionRequest target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    private String[] getNullPropertyNames(Object source) {
        // Get property names with null values
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
