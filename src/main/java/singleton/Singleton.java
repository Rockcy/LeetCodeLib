package singleton;

import java.io.Serializable;

/**
 * @author ：Rock-Cao
 * @date ：Created at 2019/11/10 16:53
 * @modified By：
 * @version: 1.0$
 */
public enum Singleton implements Serializable,Cloneable {
    /**
     * 单元素实例
     */
    INSTANCE;

    private Singleton() {

    }

   public void doSth() {

   }

}
