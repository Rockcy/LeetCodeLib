import singleton.InnerClassSingleton;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InnerClassSingletonTest {

    @Test
    public void getInstance() throws CloneNotSupportedException {
        InnerClassSingleton instance1 = InnerClassSingleton.getInstance();
        System.out.println("getInstance:"+instance1.toString()+",hashcode:"+instance1.hashCode());
        // 通过序列化方式获取实例
        InnerClassSingleton instance2 = getInstanceBySerializable();
        System.out.println("getInstanceBySerializable:"+instance2.toString()+",hashcode:"+instance2.hashCode());
        // 通过克隆方式获取实例
        InnerClassSingleton instance3 = (InnerClassSingleton) instance1.clone();
        System.out.println("getInstanceByClone:"+instance3.toString()+",hashcode:"+instance3.hashCode());
        // 通过反射方式获取实例
        InnerClassSingleton instance4 = getInstanceByReflection();
        System.out.println("getInstanceByReflection:"+instance4.toString()+",hashcode:"+instance4.hashCode());
        Assert.assertNotEquals(instance1, instance2);
        Assert.assertNotEquals(instance1, instance3);
        Assert.assertNotEquals(instance1, instance4);
    }
    private InnerClassSingleton getInstanceBySerializable() {
        // 使用了try-with-resource语法糖来简化io流资源的关闭代码
        try (ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(byteArrayOutputStream1)) {
            objectOutputStream1.writeObject(InnerClassSingleton.getInstance());
            try (ObjectInputStream objectInputStream1 = new ObjectInputStream(
                    new ByteArrayInputStream(byteArrayOutputStream1.toByteArray()))) {
                return (InnerClassSingleton) objectInputStream1.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private InnerClassSingleton getInstanceByReflection() {
        Class<InnerClassSingleton> aClass = InnerClassSingleton.class;
        try {
            Constructor<InnerClassSingleton> declaredConstructor = aClass.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance();

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}