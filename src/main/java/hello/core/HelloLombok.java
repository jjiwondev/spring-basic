package hello.core;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("my name is Lombok");
        System.out.println("helloLombok.getName() = " + helloLombok.getName());
    }
}
