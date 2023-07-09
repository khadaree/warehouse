package com.wms.persister;

import org.springframework.data.repository.CrudRepository;

import com.wms.persister.entity.NextGen;

public interface NextGenPersister extends CrudRepository<NextGen, String>{       
    
}
