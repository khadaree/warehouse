package com.wms.persister.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "NEXT_GEN")
public class NextGen {
    @Id
    @Column(name = "TABLE_NAME")
    private String tableName;

    @Column(name = "SEQ_NO")
    private int seqNo;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

}
