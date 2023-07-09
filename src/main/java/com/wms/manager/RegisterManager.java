package com.wms.manager;

import java.util.List;

import com.wms.persister.entity.Register;

public interface RegisterManager {
    public void saveRegisterDetails(Register register);

    public void updateRegisterDetails(Register register);

    public Register getRegister(int id);

    public List<Register> getRegisterListByStage(String stage);

    public List<Register> getRegisterList();
}
