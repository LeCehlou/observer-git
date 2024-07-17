import java.util.List;

public class Client {

    private String clientName;
    private List<Order> orders;

    public String getClientName() {
        return clientName;
    }

    public void addItemToOrder(Item item, Order order) {
        order.addItem(item);
    }

    public Client(String name) {
        clientName = name;
    }

    public Order createOrder() {
        Order order = new Order();
        orders.add(order);
        return order;
    }
}
