package com.carShow.binaryMotor.web;

import com.carShow.binaryMotor.entity.Owner;
import com.carShow.binaryMotor.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/owners")
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @GetMapping("/all")
    public ResponseEntity<List<Owner>> getAllOwners() {
        return new ResponseEntity<>(ownerService.getOwners(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable Long id) {
        return new ResponseEntity<>(ownerService.getOwnerById(id), HttpStatus.OK);
    }

    @RequestMapping("/addOwner")
    public ResponseEntity<Owner> addOwner(@RequestBody Owner owner) {
        return new ResponseEntity<>(ownerService.addOwner(owner), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Owner> updateOwner(@RequestBody Owner owner, @PathVariable Long id) {
        Owner updateOwner = ownerService.updateOwner(owner, id);
        return new ResponseEntity<>(updateOwner, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
