package com.wms.persister;

import com.wms.persister.entity.Register;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RegisterPersister extends CrudRepository<Register, Integer>{
    public Register findById(int id);
    public List<Register> findAllByStage(String stage);
}
