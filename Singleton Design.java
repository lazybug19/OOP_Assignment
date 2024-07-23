public class Singleton {
    public static void main(String[] args) {
        SingletonTest test1 = SingletonTest.getInstance();
        SingletonTest test2 = SingletonTest.getInstance();
    }
}

class SingletonTest {
    public static SingletonTest singleton;

    private SingletonTest() {
        System.out.println("1 instance created");
    }

    public static SingletonTest getInstance() {
        singleton = new SingletonTest();
        return singleton;
    }
}
