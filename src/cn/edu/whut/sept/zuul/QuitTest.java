/**
 * 退出测试
 */
package cn.edu.whut.sept.zuul;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuitTest {

    private static Game game = new Game();
    private static Command command1 = new Command("quit", "");
    private static Command command2 = new Command("quit", "north");

    @Test
    public void testStrategy() {
        Quit a1 = new Quit(command1, game);
        assertEquals(true, a1.copeWithCommand());

        Quit a2 = new Quit(command2, game);
        assertEquals(false, a2.copeWithCommand());

    }
}
