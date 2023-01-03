/**
 * World-of-Zuul游戏的主类。
 */
package cn.edu.whut.sept.zuul;

public class Game
{
    private Parser parser;
    private Room currentRoom;

    /**
     * 初始化游戏，创建解析器
     */
    public Game()
    {
        create();
        parser = new Parser();
    }

    /**
     * @return 返回解析器
     */
    public Parser getParser()
    {
        return parser;
    }

    /**
     * @return 返回当前房间
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }

    /**
     * @return 返回当前房间
     */
    public void setCurrentRoom(Room room)
    {
        currentRoom = room;
    }

    /**
     * 创建具体房间和物品
     */
    private void create()
    {
        Room mainBuilding, bar, office, lab, outside;
        Goods cookie, idCard, phone, cup, computer, coffee;
        mainBuilding = new Room("You are in the mainBuilding");
        bar = new Room("You are in a bar");
        office = new Room("You are in the Senior office");
        lab = new Room("You are in a computer lab");
        outside = new Room("Outside the university");

        cookie = new Goods("cookie",0.05);
        idCard = new Goods("idCard",0.1);
        phone = new Goods("phone",3);
        cup = new Goods("cup",1.5);
        computer = new Goods("computer",10);
        coffee = new Goods("coffee",0.2);

        // 初始化出口
        outside.setExit("east", mainBuilding);
        outside.setExit("south", lab);
        outside.setExit("west", bar);
        outside.setGoods(cookie);
        outside.setGoods(idCard);

        mainBuilding.setExit("west", outside);
        mainBuilding.setGoods(phone);

        bar.setExit("east", outside);
        bar.setGoods(coffee);

        lab.setExit("north", outside);
        lab.setExit("east", office);
        lab.setGoods(cup);

        office.setExit("west", lab);
        office.setGoods(computer);

        currentRoom = outside;  // 初始的时刻在外面
    }


    /**
     * 向用户展示信息
     */

    private void Welcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("if you need help,enter 'help'");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     *  循环直到用户输入退出命令后结束整个程序
     */
    public void play()
    {
        Welcome();
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = Command(command);
        }
        System.out.println("Game over, bye！");  // 游戏结束
    }


    /**
     * 执行游戏指令
     * @param command 游戏指令
     * @return 用户想要quit返回true，否则返回false
     */
    private boolean Command(Command command)
    {
        boolean quit = false;

        if(command.isBasicCommand()) {            // 无效指令,保证代码健壮性
            System.out.println("I don't know what you mean, maybe it's an invalid command!");
            return false;
        }

        switch(command.getBasicCommand()) {
            case "help": new Context(new Help(command, this)).getResult();
                break;
            case "go": {
                new Context(new Go(command, this)).getResult();
                break;
            }
            case "quit": quit = (boolean)new Context(new Quit(command, this)).getResult();
                break;
            case "look": new Context(new Look(command, this)).getResult();
                break;
            case "back": new Context(new Back(command, this)).getResult();
                break;
            case "take": new Context(new TakeAway(command, this)).getResult();
                break;
        }
        return quit;
    }

}
