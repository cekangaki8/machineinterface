package com.dpwn.newops.mobilgateway.machineinterface.controller;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RequestMapping("/mobilegateway")
@RestController
public class IndexController {

    @GetMapping("/")
    public ResourceSupport index() {
        ResourceSupport index = new ResourceSupport();
        index.add(linkTo(MachineInterfaceController.class).withRel("MachineInterfaceController"));
        return index;
    }
}