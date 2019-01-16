package com.crossover.technical.screen;

import static com.crossover.technical.screen.Tester.balancedOrNot;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TesterTest {

  @Test
  public void testBalancedOrNot_OK() {
    assertArrayEquals("Question text samples (0)", new int[]{1, 1, 1, 0, 0, 0},
        balancedOrNot(new String[]{"<<>>", "<>", "<><>", ">>", "<<>", "><><"},
            new int[]{0, 0, 0, 0, 0, 0}));
    assertArrayEquals("Question text samples (1)", new int[]{1, 1, 1, 1, 0, 0},
        balancedOrNot(new String[]{"<<>>", "<>", "<><>", ">>", "<<>", "><><"},
            new int[]{0, 0, 0, 2, 2, 2}));
    assertArrayEquals("Sample (0)", new int[]{1, 0},
        balancedOrNot(new String[]{"<>>>", "<>>>>"}, new int[]{2, 2}));
    assertArrayEquals("Sample (1)", new int[]{1, 0},
        balancedOrNot(new String[]{"<>", "<>><"}, new int[]{1, 0}));
  }

  @Test(expected = IllegalStateException.class)
  public void testBalancedOrNot_DifferentLength_1() {
    assertArrayEquals(new int[0], balancedOrNot(new String[]{"<>"}, new int[]{1, 0}));
  }

  @Test(expected = IllegalStateException.class)
  public void testBalancedOrNot_DifferentLength_2() {
    assertArrayEquals(new int[0], balancedOrNot(new String[]{"<>", "<>><"}, new int[]{1}));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBalancedOrNot_WrongCharacter() {
    assertArrayEquals(new int[0], balancedOrNot(new String[]{"<a"}, new int[]{0}));
  }
}