package gz.itcast.biz.front.order.service;

import gz.itcast.biz.front.order.dao.OrderDao;
import gz.itcast.biz.front.order.dao.OrderDaoImpl;
import gz.itcast.entity.Orders;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDao dao = new OrderDaoImpl();
    @Override
    public void saveOrder(Orders orders) {
         dao.saveOrder(orders);
    }

    @Override
    public List<Orders> queryOrders(String userId) {
        return  dao.queryOrders(userId);
    }
}
