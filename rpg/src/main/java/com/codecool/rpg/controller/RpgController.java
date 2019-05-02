package com.codecool.rpg.controller;

import com.codecool.rpg.service.Rpg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RpgController {

    @Autowired
    Rpg rpg;

    @GetMapping("/fight")
    public String fight() {
        return rpg.evaluateCombat();
    }


}
