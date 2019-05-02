package com.codecool.rpg.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Rpg {

    @Autowired
    private RollServiceCaller rollServiceCaller;

    public String evaluateCombat() {
        int heroResult = rollServiceCaller.rollForHero();
        int monsterResult = rollServiceCaller.rollForMonster();
        String winner = heroResult > monsterResult ? "Hero" : "Monster";

        return winner + " wins! " + heroResult + " vs. " + monsterResult;
    }
}
