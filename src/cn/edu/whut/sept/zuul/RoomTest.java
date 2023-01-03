/**
 * 房间测试
 */
package cn.edu.whut.sept.zuul;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest {

    private Room room1 = new Room("outside");
    private Goods goods1 = new Goods("cup", 1.5);

    @Test
    public void test1() {
        assertEquals("outside", room1.getShortDescription());

    }

    @Test
    public void test2() {
        room1.setGoods(goods1);
        assertEquals(true, room1.deleteGoods("cup"));
        assertEquals(false, room1.deleteGoods("coffee"));
    }
}
