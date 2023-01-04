/**
 * 退出
 */
package cn.edu.whut.sept.zuul;

public class Quit extends Strategy{
    public Quit(Command command, Game game) {
        super(command,game);
    }

    /**
     * Quit指令，用户退出游戏。
     * @return 如果游戏需要退出返回true，否则返回false.
     */
    @Override
    public Object copeWithCommand() {
        Command command = getCommand();
        if(command.isSpecificCommand()) {
            System.out.println("Quit now?");
            return false;
        }
        else {
            return true;
        }
    }
}
