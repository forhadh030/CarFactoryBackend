package com.carShow.binaryMotor.service;

import com.carShow.binaryMotor.entity.Owner;

import java.util.List;

public interface OwnerService {
    List<Owner> getOwners();
    Owner getOwnerById(Long id);
    Owner addOwner(Owner owner);
    Owner updateOwner(Owner owner, Long id);
    void deleteOwner(Long id);
}
