package com.wms.persister.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "REGISTER")
public class Register {
    @Id
    @Column(name = "ID")    
    private int id;

    @Column(name = "TRUCK_NO")
    private String truckNo;

    @Column(name = "WAY_BILL_NO")
    private String wayBillNo;

    @Column(name = "MILL_NAME")
    private String millName;

    @Column(name = "MILL_PLACE")
    private String millPlace;

    @Column(name = "STAGE")
    private String stage;

    @Column(name = "VERIETY")
    private String veriety;

    @Column(name = "BAGS")
    private int bags;

    @Column(name = "IN_TIME")
    private long inTime;    

    @Column(name = "OUT_TIME")
    private long outTime;    

    @Column(name = "IN_WEIGHT")
    private int inWeight;

    @Column(name = "OUT_WEIGHT")
    private int outWeight;

    @Column(name = "NET_WEIGHT")
    private int netWeight;

    @Column(name = "STORE")
    private String store;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTruckNo() {
        return truckNo;
    }

    public void setTruckNo(String truckNo) {
        this.truckNo = truckNo;
    }

    public String getWayBillNo() {
        return wayBillNo;
    }

    public void setWayBillNo(String wayBillNo) {
        this.wayBillNo = wayBillNo;
    }

    public String getMillName() {
        return millName;
    }

    public void setMillName(String millName) {
        this.millName = millName;
    }

    public String getMillPlace() {
        return millPlace;
    }

    public void setMillPlace(String millPlace) {
        this.millPlace = millPlace;
    }

    public String getVeriety() {
        return veriety;
    }

    public void setVeriety(String veriety) {
        this.veriety = veriety;
    }

    public int getBags() {
        return bags;
    }

    public void setBags(int bags) {
        this.bags = bags;
    }

    public long getInTime() {
        return inTime;
    }

    public void setInTime(long inTime) {
        this.inTime = inTime;
    }

    public long getOutTime() {
        return outTime;
    }

    public void setOutTime(long outTime) {
        this.outTime = outTime;
    }

    public int getInWeight() {
        return inWeight;
    }

    public void setInWeight(int inWeight) {
        this.inWeight = inWeight;
    }

    public int getOutWeight() {
        return outWeight;
    }

    public void setOutWeight(int outWeight) {
        this.outWeight = outWeight;
    }

    public int getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(int netWeight) {
        this.netWeight = netWeight;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }
    
}
