public class PriceObserver implements OrderObserver{

    @Override
    public void update(Order order) {
            order.setDiscount(order.getTotalPrice() > 200);
    }
}
