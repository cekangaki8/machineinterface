package com.dpwn.newops.mobilgateway.machineinterface.model;




import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class PieceToBagRequest {

    @NotBlank(message =  "Missing data for receptacleNumber.")
    private String receptacleNumber;

    @NotNull(message = "Missing data for countOfMailItems.")
    @Max(value = 200, message =  "Maximum number of mailitems acceptable cannot exceed 200")
    @Min(value = 1, message = "Atleast one mailitem must be associated to a receptacle")
    private Number countOfMailItems;

    @NotNull(message = "Missing data for mailItems.")
    @NotEmpty(message = "At least one mailitem must be provided")
    @Valid
    private List<Mailitem> mailItems;

    @NotNull(message = "")
    private Date closeTime;

    /**
     * The facility code associated with the facility
     */
    private String facilityCode;

    /**
     * The machine identifier
     */
    private String machineId;

    /**
     * This is the bin number associated with the request should be 6 characters
     */
    private String binNumber;

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public String getBinNumber() {
        return binNumber;
    }

    public void setBinNumber(String binNumber) {
        this.binNumber = binNumber;
    }

    public String getFacilityCode() {
        return facilityCode;
    }

    public void setFacilityCode(String facilityCode) {
        this.facilityCode = facilityCode;
    }


    public String getReceptacleNumber() {
        return receptacleNumber;
    }

    public void setReceptacleNumber(String receptacleNumber) {
        this.receptacleNumber = receptacleNumber;
    }

    public Number getCountOfMailItems() {
        return countOfMailItems;
    }

    public void setCountOfMailItems(Number countOfMailItems) {
        this.countOfMailItems = countOfMailItems;
    }

    public List<Mailitem> getMailItems() {
        return mailItems;
    }

    public void setMailItems(List<Mailitem> mailItems) {
        this.mailItems = mailItems;
    }
}
