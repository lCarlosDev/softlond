package com.softlond.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softlond.store.entities.Client;
import com.softlond.store.repositories.IClientRepository;

@Service
public class ClientService {

    @Autowired
    private IClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

}
