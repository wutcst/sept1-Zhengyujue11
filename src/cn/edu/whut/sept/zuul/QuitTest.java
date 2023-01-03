/**
 * 退出测试
 */
package cn.edu.whut.sept.zuul;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuitTest {

    private static Game game = new Game();
    private static Command command1 = new Command("quit", "");
    private static Command command2 = new Command("quit", "west");

    @Test
    public void testdoStrategy() {
        Quit stake1 = new Quit(command1, game);
        assertEquals(true, stake1.copeWithCommand());

        Quit stake2 = new Quit(command2, game);
        assertEquals(false, stake2.copeWithCommand());

    }
}
