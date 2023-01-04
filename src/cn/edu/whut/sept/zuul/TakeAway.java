/**
 * 拾取
 */
package cn.edu.whut.sept.zuul;

public class TakeAway extends Strategy{
    private Command command = getCommand();
    private Game game = getGame();

    public TakeAway(Command command, Game game) {
        super(command,game);
    }

    /**
     * 查看当前房间信息
     * 以及房间内物品信息
     */
    @Override
    public Object copeWithCommand() {
        String takedes = command.getSecondWord();
        if(takedes == null) {
            System.out.println("Please input the goods.");
        }

        if(game.getCurrentRoom().deleteGoods(takedes) == true){
            System.out.println("You have taken it.");
        }
        else System.out.println("There is no such goods.");

        return null;
    }
}
