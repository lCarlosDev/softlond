package com.softlond.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softlond.store.entities.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {

}
