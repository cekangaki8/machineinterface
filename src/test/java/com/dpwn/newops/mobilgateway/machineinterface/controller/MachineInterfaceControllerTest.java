package com.dpwn.newops.mobilgateway.machineinterface.controller;

import com.dpwn.newops.mobilgateway.machineinterface.model.Mailitem;
import com.dpwn.newops.mobilgateway.machineinterface.model.PieceToBagRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MachineInterfaceControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Autowired
    private MachineInterfaceController machineInterfaceController;

    @Before
    public void setUp(){
        //standaloneSetup(new HelloWorld())
        //this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
        this.mockMvc = standaloneSetup(machineInterfaceController)
                .apply(documentationConfiguration(this.restDocumentation))
                .alwaysDo(document("{method-name}",
                        preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())))
                .build();
    }

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

    /**
     * Also used for documentation, add positive test case
     * @throws Exception
     */
    @Test
    public void associatePieceToBag() throws Exception {
        PieceToBagRequest mockRequest = new PieceToBagRequest();
        mockRequest.setCountOfMailItems(1);
        mockRequest.setReceptacleNumber("9298090938909093890");
        mockRequest.setMailItems(new ArrayList<>());
        mockRequest.setCloseTime(new Date());
        Mailitem mi = new Mailitem();
        //mi.setImpb("420898989209090909090809809");
        mi.setTwoDimensionalBarcode("V2|234|1239898989090898099|12323");
        mockRequest.getMailItems().add(mi);

        ObjectMapper mapper = new ObjectMapper();


        this.mockMvc.perform(post("/mobilegateway/machineintegration/associatePiecesToBag")
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(mockRequest)))
        .andExpect(status().isOk())
        .andDo(document("piece-to-bag-example",
                requestFields(fieldWithPath("receptacleNumber").description("The receptacle number displayed on the sack"),
                        fieldWithPath("countOfMailItems").description("The total number of mailitems in the sack"),
                        fieldWithPath("mailItems").description("The detail list of mailitems"),
                        fieldWithPath("closeTime").description("The time when the receptacle was scanned"),
                        fieldWithPath("facilityCode").description("The facility code"),
                        fieldWithPath("machineId").description("The machine identifier"),
                        fieldWithPath("binNumber").description("The bin number")
                        )));
    }

}