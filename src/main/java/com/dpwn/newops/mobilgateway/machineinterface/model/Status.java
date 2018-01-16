package com.dpwn.newops.mobilgateway.machineinterface.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Status {


    private String returnCode;

    private String message;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss,SSS")
    private Date timeStamp;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
