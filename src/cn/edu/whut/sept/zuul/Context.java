/**
 * 上下文
 */
package cn.edu.whut.sept.zuul;

public class Context {
    // 业务上下文关联的算法策略接口
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public Object getResult(){
        return strategy.copeWithCommand();
    }
}

