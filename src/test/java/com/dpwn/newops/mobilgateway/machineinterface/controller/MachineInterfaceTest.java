package com.dpwn.newops.mobilgateway.machineinterface.controller;

import com.dpwn.newops.mobilgateway.machineinterface.model.Mailitem;
import com.dpwn.newops.mobilgateway.machineinterface.model.PieceToBagRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(MachineInterfaceController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class MachineInterfaceTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Also used for documentation, add positive test case
     * @throws Exception
     */
    @Test
    public void shouldAssociatePieceToBag() throws Exception {

        PieceToBagRequest mockRequest = new PieceToBagRequest();
        mockRequest.setCountOfMailItems(1);
        mockRequest.setReceptacleNumber("9298090938909093890");
        mockRequest.setMailItems(new ArrayList<>());
        mockRequest.setCloseTime(new Date());
        Mailitem mi = new Mailitem();
        mi.setTwoDimensionalBarcode("V2|234|1239898989090898099|12323");
        mockRequest.getMailItems().add(mi);

        ObjectMapper mapper = new ObjectMapper();

        this.mockMvc.perform(post("/mobilegateway/machineintegration/associatePiecesToBag")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(mockRequest)))
                .andExpect(status().isOk())
                .andDo(document("Piece-to-bag",
                        requestFields(fieldWithPath("receptacleNumber").optional().type("String").description("The receptacle number displayed on the sack"),
                                fieldWithPath("countOfMailItems").type("Integer").description("The total number of mailitems in the sack"),
                                fieldWithPath("mailItems").type("Array").description("The detail list of mailitems"),
                                fieldWithPath("closeTime").type("Date").description("The time when the receptacle was scanned"),
                                fieldWithPath("facilityCode").type("String").description("The facility code"),
                                fieldWithPath("machineId").type("String").description("The machine identifier"),
                                fieldWithPath("binNumber").type("String").description("The bin number")
                        )));

    }


}
