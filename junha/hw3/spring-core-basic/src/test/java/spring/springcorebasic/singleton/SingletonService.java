package spring.springcorebasic.singleton;

public class SingletonService {

	// static으로 선언하여 싱글톤으로 구성
	private static final SingletonService instance = new SingletonService();

	public static SingletonService getInstance(){
		return instance;
	}


	// private 접근 지정자로 객체 생성을 막음
	private SingletonService(){ }

	public void logic(){
		System.out.println("싱글톤 객체 로직 호출");
	}

}

