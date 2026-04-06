package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class HelleLombok {

  private String name;
  private int age;


    public static void main(String[] args) {

      HelleLombok hl = new HelleLombok();
      hl.setAge(12);
      hl.setName("Name A");
      int age  = hl.getAge();
      String name = hl.getName();

      System.out.println("helleLombok : " + hl);
      System.out.println("name : " + name );


    }

}
