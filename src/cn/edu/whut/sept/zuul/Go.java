/**
 * 执行
 */
package cn.edu.whut.sept.zuul;

public class Go extends Strategy{

    private Command command = getCommand();
    private Game game = getGame();

    public Go(Command command, Game game) {
        super(command,game);
    }

    /**
     * go指令，向房间的指定方向出口移动，如果该出口连接了另一个房间，会进入该房间
     */
    @Override
    public Object copeWithCommand() {
        if(!command.isSpecificCommand()) {
            // 如果用户只输入了一个动作，比如go，那么我们就无法知道去哪个方向的哪个房间，输出提示信息
            System.out.println("Where are you going?");
            return "I don't know where do you want to go.";
        }

        String direction = command.getSecondWord();

        Room nextRoom = game.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no exit，Please look for other exits.");
        }
        else {
            game.setCurrentRoom(nextRoom);
            System.out.println(game.getCurrentRoom().getDetailedDescription());
        }
        return "Success!";
    }
}
