package com.dpwn.newops.mobilgateway.machineinterface.model;

public class PieceToBagResponse {

    private PieceToBagAcknowledgement receivedInformation;

    private Status status;

    public PieceToBagAcknowledgement getReceivedInformation() {
        return receivedInformation;
    }

    public void setReceivedInformation(PieceToBagAcknowledgement receivedInformation) {
        this.receivedInformation = receivedInformation;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
