package com.catan.democatanserver.controllers;

import catan.builders.LandHexBuilder;
import catan.map.Resource;
import catan.map.hex.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class CatanController {

    Logger logger = LoggerFactory.getLogger(CatanController.class);

    @MessageMapping("/getMap")
    @SendTo("/topic/catan")
    public Hex getMap() {
        logger.info("Sending map");
        return new LandHexBuilder().setResource(Resource.Desert).getHex();
    }
}
