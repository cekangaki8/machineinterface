package com.dpwn.newops.mobilgateway.machineinterface.model;

public class PieceToBagAcknowledgement {

    private Number countReported;

    private Number numberOfMailItemsReceived;


    public Number getCountReported() {
        return countReported;
    }

    public void setCountReported(Number countReported) {
        this.countReported = countReported;
    }

    public Number getNumberOfMailItemsReceived() {
        return numberOfMailItemsReceived;
    }

    public void setNumberOfMailItemsReceived(Number numberOfMailItemsReceived) {
        this.numberOfMailItemsReceived = numberOfMailItemsReceived;
    }
}
