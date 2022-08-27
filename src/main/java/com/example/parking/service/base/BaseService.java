package com.example.parking.service.base;

import com.example.parking.model.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService <E extends BaseEntity,ID extends Serializable>{
    void save(E e);

    Optional<E> findById(ID id);

    void delete(E e);

    List<E> findAll();
}
