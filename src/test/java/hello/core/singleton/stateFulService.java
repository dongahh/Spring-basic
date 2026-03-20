package hello.core.singleton;

public class stateFulService {

    private int price ;

    void order(String name, int price){
        System.out.println("name is " + name +", price is " + price);
        this.price = price;
    }
    int order2(String name, int price){
        return price;
    }
    public int getPrce(){
       return price;
    }
}
