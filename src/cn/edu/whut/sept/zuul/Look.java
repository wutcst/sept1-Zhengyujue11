/**
 * 查看周围物品
 */
package cn.edu.whut.sept.zuul;

public class Look extends Strategy{

    private Game game = getGame();

    public Look(Command command, Game game) {
        super(command,game);
    }

    /**
     * 查看当前房间信息和房间内物品信息
     */
    @Override
    public Object copeWithCommand() {
        System.out.println("The information of this room is");
        String s = game.getCurrentRoom().getBriefDescription();
        System.out.println(s);
        System.out.println("The information of the goods is");
        for(Goods goods : game.getCurrentRoom().getGoods())
        {
            System.out.print(goods.getDescription());
            System.out.print(" ,it weights:");
            System.out.print(goods.getWeight());
            System.out.println("kg");
        }
        return null;
    }
}
