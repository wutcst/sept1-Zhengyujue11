/**
 * 帮助
 */
package cn.edu.whut.sept.zuul;

public class Help extends Strategy{
    private Game game = getGame();

    public Help(Command command, Game game) {
        super(command,game);
    }

    /**
     * help指令，打印游戏帮助信息
     */
    @Override
    public Object copeWithCommand() {
        System.out.println("You wander around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        game.getParser().showCommands();
        System.out.println("");
        return null;
    }

}

