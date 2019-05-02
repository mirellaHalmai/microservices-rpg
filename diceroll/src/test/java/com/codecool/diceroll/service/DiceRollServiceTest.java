package com.codecool.diceroll.service;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DiceRollServiceTest {

    @Autowired
    private DiceRollService service;

    @RepeatedTest(50)
    public void rollD6() {
        assertThat(service.rollD6()).isBetween(1, 6);
    }

    @RepeatedTest(50)
    public void rollD20() {
        assertThat(service.rollD20()).isBetween(1, 20);
    }
}