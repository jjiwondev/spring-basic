package hello.core.singleton;

//public class StatefulService {
//    //singleton의 문제점을 설명하기 위한 예제
//    private int price;
//
//    public void order(String name, int price){
//        System.out.println("name = " + name + " price = " + price);
//        this.price = price; //여기서 문제가 생김!!
//    }
//    public int getPrice(){
//        return price;
//    }
//}
//싱글톤의 문제점 해결 -> 공유되지 않는 변수를 사용하라
public class StatefulService {
//    private int price;

    public int order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; //여기서 문제가 생김!!
        return price;
    }

//    public int getPrice(){
//        return price;
//    }
}