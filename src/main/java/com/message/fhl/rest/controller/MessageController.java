package com.message.fhl.rest.controller;

import com.message.fhl.domain.FHLMessage;
import com.message.fhl.service.MessageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/fhl-messages")
public class MessageController {

    private static final Logger LOGGER = LogManager.getLogger(MessageController.class);
    @Autowired
    private MessageService messageService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveMessage(@RequestBody FHLMessage fhlMessage) throws Exception {
        messageService.save(fhlMessage);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
