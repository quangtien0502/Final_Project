package com.ra.service;

import com.ra.model.entity.Address;

import java.util.List;

public interface IAddressService {
    List<Address> getAll();
    Address save(Address address);
    Address findById(Long id);
    void deleteById(Long id);
}
