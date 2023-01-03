/**
 * 接收用户输入的命令，包括commandWord和secondWord
 */
package cn.edu.whut.sept.zuul;

public class Command
{
    private String BasicCommand;  // 基础指令

    private String SpecificCommand;   // 具体指令

    /**
     * 接收用户指令
     */
    public Command(String firstWord, String secondWord)
    {
        BasicCommand = firstWord;
        this.SpecificCommand = secondWord;
    }

    /**
     *
     * @return 返回基础指令
     */
    public String getBasicCommand()
    {
        return BasicCommand;
    }

    /**
     *
     * @return 返回具体指令
     */
    public String getSecondWord()
    {
        return SpecificCommand;
    }

    public void setSecondWord(String second)
    {
        SpecificCommand = second;
    }

    /**
     * 判断基础指令是否为空
     * @return BasicCommand为空，则返回true，否则返回false
     */
    public boolean isBasicCommand()
    {
        return (BasicCommand == null);
    }

    /**
     * 判断具体指令是否为空
     * @return SpecificCommand不为空，返回true，否则返回false
     */
    public boolean isSpecificCommand()
    {
        return (SpecificCommand != null);
    }
}
