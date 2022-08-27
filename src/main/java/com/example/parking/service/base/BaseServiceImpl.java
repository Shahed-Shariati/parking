package com.example.parking.service.base;

import com.example.parking.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<R extends JpaRepository<E,ID>, E extends BaseEntity,ID extends Serializable> implements BaseService<E,ID>{

    protected R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override

    public void save(E e) {
        repository.save(e);
    }

    @Override
    public Optional<E> findById(ID id) {
        return repository.findById(id);
    }


    @Override
    public void delete(E e) {
        repository.delete(e);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }


}
