package com.wms.manager;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.persister.NextGenPersister;
import com.wms.persister.entity.NextGen;

@Service
public class NextGenKeyHandler {
    @Autowired
    NextGenPersister nextGenPersister;

    public int getNextKey(String tableName){
        int result = 0;
        Optional<NextGen> optional = nextGenPersister.findById(tableName);
        NextGen nextGen = optional.get();
        if(nextGen != null){
            result = nextGen.getSeqNo();
            nextGen.setSeqNo(result+1);
            nextGenPersister.save(nextGen);
        }
        return result;
    }

}
