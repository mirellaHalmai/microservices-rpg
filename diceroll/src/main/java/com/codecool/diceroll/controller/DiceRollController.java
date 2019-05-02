package com.codecool.diceroll.controller;

import com.codecool.diceroll.service.DiceRollService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/roll")
public class DiceRollController {

    @Autowired
    private DiceRollService diceRollService;

    @Autowired
    private Environment env;

    @GetMapping("/d6")
    public Roll rollD6() {
        return new Roll(
                diceRollService.rollD6(),
                "D6",
                env.getProperty("server.port")
        );
    }

    @GetMapping("/d20")
    @ApiOperation(value = "HELLO D20")
    public Roll rollD20() {
        return new Roll(
                diceRollService.rollD20(),
                "D20",
                env.getProperty("server.port")
        );
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Roll {

        private int result;
        private String dice;
        private String port;
    }

}
