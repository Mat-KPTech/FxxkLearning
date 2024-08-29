import java.lang.ref.WeakReference;

public class WeakReferenceDemo {

    public static void main(String[] args) {

        WeakReference<String> weakReferenceDemo = new WeakReference<>(new String("abc"));
        System.out.println(weakReferenceDemo.get());
        System.gc(); // 触发垃圾回收
        System.out.println(weakReferenceDemo.get());

    }

}
