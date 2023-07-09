package com.wms.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.persister.RegisterPersister;
import com.wms.persister.entity.Register;

@Service
public class RegisterManagerImpl implements RegisterManager{

    @Autowired
    RegisterPersister registerPersister;

    @Autowired
    NextGenKeyHandler nextGenKeyHandler;

    @Override
    public void saveRegisterDetails(Register register) {
        register.setId(nextGenKeyHandler.getNextKey("REGISTER"));
        registerPersister.save(register);        
    }

    @Override
    public void updateRegisterDetails(Register register) {        
        registerPersister.save(register);        
    }

    @Override
    public Register getRegister(int id) {
        return registerPersister.findById(id);
    }

    @Override
    public List<Register> getRegisterList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRegisterList'");
    }

    @Override
    public List<Register> getRegisterListByStage(String stage) {
        return registerPersister.findAllByStage(stage);
    }
    
}
