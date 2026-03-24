package hello.core.order;

public interface OrderService {

    Order creadOrder(Long memberId, String itemName, int itmePrice);

}
