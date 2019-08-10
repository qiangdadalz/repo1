package gz.itcast.biz.front.buy.web;

import gz.itcast.entity.Books;
import gz.itcast.util.BaseServlet;
import gz.itcast.util.WebUtil;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 购物车模块的servlet
 * @author APPle
 *
 */


public class BuyServlet extends BaseServlet {

    //把一本书加到购物车中
    public void addToCat(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        //1）接收用户购买的图书的信息,使用WebUtil工具类将url携带的数据封装到bean中
        Books book = WebUtil.copyRequestToBean(request,Books.class);
        //2）创建一个Map集合car来保存购物车的所有图书的信息
        //先从session中读取购物车的数据
        Map<String,Books> car = (Map<String, Books>) session.getAttribute("car");
        if (car==null){
            //car为null，说明购物车中无数据，是第一次访问购物车，创建一个购物车car
            car = new HashMap<String, Books>();
        }
        /**
         *  反之购物车中有数据，使用原来的购物车，不用新new
         *  数量问题：
         *  	1）如果是当前购物车中没有这本书，则为1
         *  	2）如果当前购物车中有了这本书，则为 （当前数量+1）
         */
        if(car.containsKey(book.getId())){
            //当前购物车中有了这本书
            //获取购物现有的数量+1
            book.setAmt(car.get(book.getId()).getAmt()+1);
        }else {
            book.setAmt(1);
        }
        //3）把图书放入购物车中
         car.put(book.getId(),book);
        //4）把购物车对象放入session中
        session.setAttribute("car",car);
        //5）跳转到购物车car.jsp页面
        response.sendRedirect(request.getContextPath()+"/jsp/front/buy/car.jsp");
    }
}
