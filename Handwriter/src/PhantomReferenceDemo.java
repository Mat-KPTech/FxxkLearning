import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Date;

public class PhantomReferenceDemo {

    private static class MyClass {

        private Date birthTime;

        public MyClass() {
            birthTime = new Date();
        }

    }

    public static void main(String[] args) {
        ReferenceQueue<MyClass> queue = new ReferenceQueue<>();
        PhantomReference<MyClass> phantomReference = new PhantomReference<>(new MyClass(), queue);


    }

}
