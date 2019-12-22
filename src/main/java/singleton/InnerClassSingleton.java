package singleton;

import java.io.Serializable;

/**
 * @author ：Rock-Cao
 * @date ：Created at 2019/11/10 19:44
 * @modified By：
 * @version: 1.0$
 */
public class InnerClassSingleton implements Serializable,Cloneable {
    private static final long serialVersionUID = 1L;
    private InnerClassSingleton() {

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private static class SingletonHolder{
        private static final InnerClassSingleton INSTANCE= new InnerClassSingleton();
    }
    public static InnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
