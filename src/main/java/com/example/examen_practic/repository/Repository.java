package com.example.examen_practic.repository;

import java.util.List;

public interface Repository<E, ID> {
    E save(E entity);

    E delete(ID id);

    E findOne(ID id);

    E update(E entity,ID id);

    List<E> findAll();
}