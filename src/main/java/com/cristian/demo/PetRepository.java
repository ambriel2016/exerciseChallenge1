package com.cristian.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PetRepository extends CrudRepository<Pet, Long> {

    ArrayList<Pet> findByName(String name);
}
