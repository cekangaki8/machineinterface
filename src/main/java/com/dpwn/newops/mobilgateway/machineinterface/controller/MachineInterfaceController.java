package com.dpwn.newops.mobilgateway.machineinterface.controller;


import com.dpwn.newops.mobilgateway.machineinterface.model.PieceToBagAcknowledgement;
import com.dpwn.newops.mobilgateway.machineinterface.model.PieceToBagRequest;
import com.dpwn.newops.mobilgateway.machineinterface.model.PieceToBagResponse;
import com.dpwn.newops.mobilgateway.machineinterface.model.Status;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


@RestController
@RequestMapping("/mobilegateway/machineintegration")
public class MachineInterfaceController {

    @RequestMapping(method = RequestMethod.POST, value = ("/associatePiecesToBag"))
    PieceToBagResponse doPieceToBagAssociation(@Validated @RequestBody PieceToBagRequest pieceToBagRequest) {


        if (pieceToBagRequest.getCountOfMailItems().intValue() != pieceToBagRequest.getMailItems().size()) {
            String message = String.format("Mismatch count mailitems. Expecting %d but received %d.",
                    pieceToBagRequest.getCountOfMailItems().intValue(), pieceToBagRequest.getMailItems().size());
            throw new IllegalArgumentException(message);
        }
        /*boolean isBothImpbAndTwoBarcodeEmpty = pieceToBagRequest.getMailItems().stream()
                                        .anyMatch(mi -> null == mi.getImpb() && null == mi.getTwoDimensionalBarcode());
        if (isBothImpbAndTwoBarcodeEmpty)
            throw new IllegalArgumentException("MailItems missing both IMPB and 2D barcode");*/
      PieceToBagResponse response = new PieceToBagResponse();

      response.setStatus(new Status());
      response.getStatus().setMessage(String.format("Successfully received %d mailitems for processing",
              pieceToBagRequest.getCountOfMailItems().intValue()));
      response.getStatus().setReturnCode("0");
      response.getStatus().setTimeStamp(new Date());

      response.setReceivedInformation(new PieceToBagAcknowledgement());
      response.getReceivedInformation().setCountReported(pieceToBagRequest.getCountOfMailItems());
      response.getReceivedInformation().setNumberOfMailItemsReceived(pieceToBagRequest.getMailItems().size());

      return response;
    }


    @ExceptionHandler
    void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }


}
