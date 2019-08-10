package gz.itcast.biz.front.order.dao;

import gz.itcast.entity.Orders;

import java.util.List;


public interface OrderDao {

    //下订单
    //orders中一定要包含List<OrderLine>
    public void saveOrder(Orders orders);
    //根据用户id查询对应的订单
    public List<Orders> queryOrders(String userId);
}
