/**
 * 系统内部指令
 */
package cn.edu.whut.sept.zuul;

public class CommandWords
{
    private static final String[] validCommands = {     // 系统内部指令含有go、quit、help、look、back、take
            "go",
            "quit",
            "help",
            "take",
            "look",
            "back"
    };

    public CommandWords() {  //无参构造

    }

    /**
     * 判断字符串是否为有效指令.
     * @param instructions 键入的指令
     * @return 有效指令返回true，无效返回false.
     */
    public boolean isCommand(String instructions)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(instructions))  // 判断是否为有效指令
                return true;
        }
        return false;
    }

    /**
     * 显示所有有效指令
     */
//    public void showAll()
//    {
//        for(String command: validCommands) {
//            System.out.print(command + "  ");
//        }
//        System.out.println();
//    }
}
