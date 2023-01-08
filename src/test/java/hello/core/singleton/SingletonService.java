package hello.core.singleton;

public class SingletonService {
    private static  final SingletonService instance = new SingletonService();
    //자기 자신을 내부에 private static으로 선언 시 하나만 존재하게 된다

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){
        //private 생성자. 다른 곳에서의 new 생성을 막음
    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
