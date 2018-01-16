package com.dpwn.newops.mobilgateway.machineinterface.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Mailitem {

   /* @JsonProperty("IMPB")
    private String impb;*/

    @JsonProperty("2D")
    private String twoDimensionalBarcode;

    public Date getConfirmedDischargeTime() {
        return confirmedDischargeTime;
    }

    public void setConfirmedDischargeTime(Date confirmedDischargeTime) {
        this.confirmedDischargeTime = confirmedDischargeTime;
    }

    /**Date time this is going to confirmed discharge. */
    private Date confirmedDischargeTime;

/*
    public String getImpb() {
        return impb;
    }

    public void setImpb(String impb) {
        this.impb = impb;
    }*/

    public String getTwoDimensionalBarcode() {
        return twoDimensionalBarcode;
    }


    public void setTwoDimensionalBarcode(String twoDimensionalBarcode) {
        this.twoDimensionalBarcode = twoDimensionalBarcode;
    }
}
