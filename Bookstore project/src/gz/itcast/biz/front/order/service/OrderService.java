package gz.itcast.biz.front.order.service;

import gz.itcast.entity.Orders;

import java.util.List;

public interface OrderService {
    public void saveOrder(Orders orders);
    public List<Orders> queryOrders(String userId);
}
