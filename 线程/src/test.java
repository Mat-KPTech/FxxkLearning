public class test {
    public static void main(String[] args) {
        // 使⽤匿名类创建 Thread ⼦类对象
        Thread t1 = new Thread(() -> System.out.println("使⽤匿名类创建 Thread ⼦类对象"));
    }
}