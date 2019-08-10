package gz.itcast.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

/**
 * 编码过滤器
 */
public class EncodingFilter  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        /**
         *  思路：使用装饰者模式，装饰HttpServletRequest对象
         */
        //解决post参数提交的问题
        request.setCharacterEncoding("utf-8");
        MyRequest myRequest = new MyRequest((HttpServletRequest)request);
        //放行，放行的请求对象是装饰后的请求对象
        chain.doFilter(myRequest,response);
    }

    @Override
    public void destroy() {

    }
}

//装饰类
class MyRequest  extends HttpServletRequestWrapper{
    private HttpServletRequest request;

    public MyRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public String getParameter(String name) {
        try {

            /**
             * GET提交参数问题
             */
            //原来的
            String value = this.request.getParameter(name);
            if ("GET".equals(this.request.getMethod())) {

                value = new String(value.getBytes("iso-8859-1"), "utf-8");
            }
            return value;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
