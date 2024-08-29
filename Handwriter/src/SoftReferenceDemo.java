import javax.xml.crypto.Data;
import java.lang.ref.SoftReference;

public class SoftReferenceDemo {

    public static class DataBlock {

        private final byte[] bytes;

        public DataBlock(int byteCount) {
            bytes = new byte[byteCount];
        }

        public String toString() {
            return "DataBlock(byteCount=" + bytes.length + ")";
        }

    }

    public static void main(String[] args) {
        SoftReference<DataBlock> demo = new SoftReference(new DataBlock(1024 * 1024 * 10));
        System.out.println(demo.get());
    }
}
