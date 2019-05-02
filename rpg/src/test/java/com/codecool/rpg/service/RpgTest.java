package com.codecool.rpg.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class RpgTest {

    @Mock
    private RollServiceCaller rollServiceCaller;

    @InjectMocks
    private Rpg rpg;

    @Test
    void evaluateCombatMonsterWins() {
        when(rollServiceCaller.rollForHero()).thenReturn(12);
        when(rollServiceCaller.rollForMonster()).thenReturn(20);
        assertThat(rpg.evaluateCombat()).isEqualTo("Monster wins! 12 vs. 20");
    }

    @Test
    void evaluateCombatHeroWins() {
        when(rollServiceCaller.rollForHero()).thenReturn(15);
        when(rollServiceCaller.rollForMonster()).thenReturn(2);
        assertThat(rpg.evaluateCombat()).isEqualTo("Hero wins! 15 vs. 2");
    }

}