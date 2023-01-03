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
     * 查看当前房间信息
     * 以及房间内物品信息
     */
    @Override
    public Object copeWithCommand() {
        System.out.println("This room's description is ");
        String s = game.getCurrentRoom().getShortDescription();
        System.out.println(s);
        System.out.println("The goods in this room is ");
        for(Goods goods : game.getCurrentRoom().getGoods())
        {
            System.out.print(goods.getDescription());
            System.out.print(" ,it weights ");
            System.out.print(goods.getWeight());
            System.out.println("kg");
        }
        return null;
    }
}
