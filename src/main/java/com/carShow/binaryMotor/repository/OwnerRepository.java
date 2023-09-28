package com.carShow.binaryMotor.repository;

import com.carShow.binaryMotor.entity.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
