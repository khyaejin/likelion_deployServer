package spring.springcorebasic.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    private SingletonService() { //private 으로 보호
    }

    public static SingletonService getInstance() {
        return instance;
    }

    public void logic() {
        System.out.println("SingleTon Service 예제");
    }

}