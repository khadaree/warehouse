package com.wms.persister;

import com.wms.persister.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author khada
 */
public interface UserPersister extends CrudRepository<User, Integer>{       
}
