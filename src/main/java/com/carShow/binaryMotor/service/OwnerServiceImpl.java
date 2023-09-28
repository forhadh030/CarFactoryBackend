package com.carShow.binaryMotor.service;

import com.carShow.binaryMotor.entity.Owner;
import com.carShow.binaryMotor.exception.ResourceNotFoundException;
import com.carShow.binaryMotor.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService{

    private OwnerRepository ownerRepository;

    OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<Owner> getOwners() {
        return (List<Owner>) ownerRepository.findAll();
    }

    @Override
    public Owner getOwnerById(Long id) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);

        if(optionalOwner.isPresent()) {
            return optionalOwner.get();
        } else {
            throw new ResourceNotFoundException("The owner with id " + id + " could not be found.");
        }
    }

    @Override
    public Owner addOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner updateOwner(Owner owner, Long id) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);
        if(optionalOwner.isPresent()) {
            optionalOwner.get().setFirstName(owner.getFirstName());
            optionalOwner.get().setLastName(owner.getLastName());
            return optionalOwner.get();
        } else {
            throw new ResourceNotFoundException("The person with id " + id + " does not exist in our system.");
        }
    }

    @Override
    public void deleteOwner(Long id) {
        if(ownerRepository.findById(id).isPresent()) {
            ownerRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("The person with id " + id + " does not exist in our system.");
        }
    }
}
