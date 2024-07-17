import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    private final List<Item> items;
    private final List<OrderObserver> observers;
    private double totalPrice;
    private String id;
    private boolean shippingCosts;
    private boolean discount;

    public Order() {
        items = new ArrayList<>();
        observers = new ArrayList<>();
        shippingCosts = true;
        discount = false;
        id = UUID.randomUUID().toString();
    }

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    public double getTotalPrice() {
        return totalPrice + (shippingCosts ? 10 : 0) - (discount ? 20 : 0);
    }

    public void setTotalPrice(double price) {
        this.totalPrice = price;
    }

    public int getCount() {
        return items.size();
    }

    public void addItem(Item item) {
        items.add(item);
        totalPrice += item.getUnitPrice();
        observers.forEach(observer -> observer.update(this));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("The content of the order (ID : ").append(" ) is : \n");
        for (Item item : items) {
            stringBuilder.append(item.getName()).append(", ").append(item.getUnitPrice()).append("\n");
        }
        return stringBuilder.toString();
    }

    public void setShippingCosts(boolean bool) {
        shippingCosts = bool;
    }

    public void setDiscount(boolean bool) {
        discount = bool;
    }
}
