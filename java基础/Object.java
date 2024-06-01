/**
 * Object类是所有类的父类，所有的类
 */
public class Object {

    /**g
     * 构造函数
     */
    public Object(){}

    /**
     * native 调用非java类的方法
     */
    public final native Class<?> getClass();

    public native int hashCode();

    public boolean equals (Object obj) {
        return this == obj;
    }


}