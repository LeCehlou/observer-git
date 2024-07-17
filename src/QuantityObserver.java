public class QuantityObserver implements OrderObserver{

    @Override
    public void update(Order order) {
        order.setShippingCosts(order.getCount() <= 5);
    }
}
