package gz.itcast.filter;

import gz.itcast.entity.Users;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 前台用户的权限的过滤
 * 购物车：
 /buy?action=AddToCar
 请求：/buy
 页面：/jsp/front/buy/*
 收货地址:
 /address?action=xxxx
 请求：/address
 页面： /jsp/front/address/*
 订单:
 /order?action=xxx
 请求：/order
 页面： /jsp/front/order/*
 * @author APPle
 *
 */

public class UserSecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //执行过滤任务
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        //1)判断用户是否已经登录
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse)resp;

        HttpSession session = request.getSession(false);
        if (session==null){
            //跳转到登录页面
            response.sendRedirect(request.getContextPath()+"/jsp/front/user/login.jsp");
            return;
        }else {
            Users loginUser = (Users)session.getAttribute("user");
            if (loginUser==null){
                //跳转到登录页面
                response.sendRedirect(request.getContextPath()+"/jsp/front/user/login.jsp");
                return;
            }
        }

        //放行
        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }
}
