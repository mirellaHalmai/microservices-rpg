package com.codecool.rpg.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DiceRollResult {

    private int result;
    private String dice;
    private String port;
}
