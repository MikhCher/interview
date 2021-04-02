package leetcode;

import org.junit.jupiter.api.Test;

import  static org.junit.Assert.*;

class ReturnToOriginTest {
    @Test
    public void whenRobotReturnsToOrigin() {
        String input = "UD";
        boolean result = new ReturnToOrigin().judgeCircle(input);
        assertTrue(result);
    }

    @Test
    public void whenRobotNotReturnsToOrigin() {
        String input = "LL";
        boolean result = new ReturnToOrigin().judgeCircle(input);
        assertFalse(result);
    }

    @Test
    public void whenRobotNotReturnsToOriginAgain() {
        String input = "RRDD";
        boolean result = new ReturnToOrigin().judgeCircle(input);
        assertFalse(result);
    }

    @Test
    public void whenRobotNotReturnsToOriginWithDifficultTrajectory() {
        String input = "LDRRLRUULR";
        boolean result = new ReturnToOrigin().judgeCircle(input);
        assertFalse(result);
    }
}