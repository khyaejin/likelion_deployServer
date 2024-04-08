package spring.springcorebasic.singleTon;

public class SingleTonService {
    private static final SingleTonService instance = new SingleTonService();

    private SingleTonService() {
    }

    public static SingleTonService getInstance() {
        return instance;
    }

    public void logic() {
        System.out.println("SingleTon Service 예제");
    }

}
