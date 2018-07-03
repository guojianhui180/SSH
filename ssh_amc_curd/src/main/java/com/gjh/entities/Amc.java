package com.gjh.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class Amc {
    private Integer id;
    private String endItem;
    private String component;
    private Double qtyIssuedAverage;
    private String endJobLot;
    private String rawItemLotNum;
    private String org;
    private String endJobNumber;
    private Byte level;
    private String parentJob;
    private String parentItem;
    private String locked="N";
    private String updateUser="unknown";
    private Timestamp updateTime=new Timestamp(new Date().getTime());  ;
    private String bONDUNBOND;

    public String getbONDUNBOND() {
        return bONDUNBOND;
    }

    public void setbONDUNBOND(String bONDUNBOND) {
        this.bONDUNBOND = bONDUNBOND;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndItem() {
        return endItem;
    }

    public void setEndItem(String endItem) {
        this.endItem = endItem;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Double getQtyIssuedAverage() {
        return qtyIssuedAverage;
    }

    public void setQtyIssuedAverage(Double qtyIssuedAverage) {
        this.qtyIssuedAverage = qtyIssuedAverage;
    }

    public String getEndJobLot() {
        return endJobLot;
    }

    public void setEndJobLot(String endJobLot) {
        this.endJobLot = endJobLot;
    }

    public String getRawItemLotNum() {
        return rawItemLotNum;
    }

    public void setRawItemLotNum(String rawItemLotNum) {
        this.rawItemLotNum = rawItemLotNum;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getEndJobNumber() {
        return endJobNumber;
    }

    public void setEndJobNumber(String endJobNumber) {
        this.endJobNumber = endJobNumber;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public String getParentJob() {
        return parentJob;
    }

    public void setParentJob(String parentJob) {
        this.parentJob = parentJob;
    }

    public String getParentItem() {
        return parentItem;
    }

    public void setParentItem(String parentItem) {
        this.parentItem = parentItem;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amc amc = (Amc) o;
        return Objects.equals(endItem, amc.endItem) &&
                Objects.equals(component, amc.component) &&
                Objects.equals(qtyIssuedAverage, amc.qtyIssuedAverage) &&
                Objects.equals(endJobLot, amc.endJobLot) &&
                Objects.equals(rawItemLotNum, amc.rawItemLotNum) &&
                Objects.equals(org, amc.org) &&
                Objects.equals(endJobNumber, amc.endJobNumber) &&
                Objects.equals(level, amc.level) &&
                Objects.equals(parentJob, amc.parentJob) &&
                Objects.equals(parentItem, amc.parentItem) &&
                Objects.equals(locked, amc.locked) &&
                Objects.equals(updateUser, amc.updateUser) &&
                Objects.equals(updateTime, amc.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(endItem, component, qtyIssuedAverage, endJobLot, rawItemLotNum, org, endJobNumber, level, parentJob, parentItem, locked, updateUser, updateTime);
    }

    @Override
    public String toString() {
        return "Amc{" +
                "id=" + id +
                ", endItem='" + endItem + '\'' +
                ", component='" + component + '\'' +
                ", qtyIssuedAverage=" + qtyIssuedAverage +
                ", endJobLot='" + endJobLot + '\'' +
                ", rawItemLotNum='" + rawItemLotNum + '\'' +
                ", org='" + org + '\'' +
                ", endJobNumber='" + endJobNumber + '\'' +
                ", level=" + level +
                ", parentJob='" + parentJob + '\'' +
                ", parentItem='" + parentItem + '\'' +
                ", locked='" + locked + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
