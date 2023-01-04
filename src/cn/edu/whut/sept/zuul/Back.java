/**
 * 返回
 */
package cn.edu.whut.sept.zuul;

public class Back extends Strategy{

    private Game game = getGame();

    public Back(Command command, Game game) {
        super(command, game);
    }

    /**
     * 执行back命令，回到上一个房间
     */
    @Override
    public Object copeWithCommand() {
        String second = game.getParser().getSecond();
        if(second == null)
        {
            System.out.printf("You're in the first room.");
            return null;
        }
        Command command = new Command("go", null);
        System.out.println("You are back.");
        /**
         * 每次都返回对应的方向 east对应west，south对应north
         */
        switch (second)
        {
            case "east":
            {
                command.setSecondWord("west");
                new Context(new Go(command, game)).getResult();
                break;
            }
            case "west":
            {
                command.setSecondWord("west");
                new Context(new Go(command, game)).getResult();
                break;
            }
            case "north":
            {
                command.setSecondWord("south");
                new Context(new Go(command, game)).getResult();
                break;
            }
            case "south":
            {
                command.setSecondWord("north");
                new Context(new Go(command, game)).getResult();
                break;
            }

        }
        return null;
    }
}
