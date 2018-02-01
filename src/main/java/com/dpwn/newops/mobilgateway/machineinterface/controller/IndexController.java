package com.dpwn.newops.mobilgateway.machineinterface.controller;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RequestMapping("/mobilegateway")
@RestController
public class IndexController {

    @GetMapping("/index")
    public ResourceSupport index() {
        ResourceSupport index = new ResourceSupport();
        index.add(linkTo(MachineInterfaceController.class).withRel("MachineInterfaceController"));
        return index;
    }

    @GetMapping("/")
    public Map<String, Object> greeting() {
        return Collections.singletonMap("message", "Hello World");
    }

    @PostMapping("/endpoint")
    public String returnValue(String value) {
        return "Testing endpoint";
    }
}