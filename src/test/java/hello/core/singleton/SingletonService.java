package hello.core.singleton;

public class SingletonService {
    //static영역에 미리 인스턴스 한개를 생성해 놔서 이것을 공유해서 쓰는 방법
    private static SingletonService instance = new SingletonService();

    //아래의 getInstance를 통해 미리 생성해준 instace를 내보내주는 방법으로 객체를 공유
    public static SingletonService getInstance() {
        return instance;
    }

    //constructor는 private로 생성하여 new SingletonService()등으로 getInstance를 통하지않고 객체를 생성하는 것을 방지.
    private SingletonService() {
    }
    public void logic(){
        System.out.println("싱글톤 객체 호출");
    }
}
