package gz.itcast.biz.front.index.web;

import gz.itcast.biz.front.index.service.IndexService;
import gz.itcast.biz.front.index.service.IndexServiceImpl;
import gz.itcast.entity.Types;
import gz.itcast.util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *  首页模块的servlet
 */
public class IndexServlet extends BaseServlet {

    IndexService service = new IndexServiceImpl();

    /**
     * 显示首页图书分类的方法
     * 用户请求的URL：/index?action=showIndex
     */

    public void showIndex(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        //1）到service取数据
        List<Types> types = service.queryTypes();

        //2）通过域对象共享分类数据到jsp页面
        request.setAttribute("types",types);
        request.getRequestDispatcher("/jsp/front/index/shopIndex.jsp").forward(request,response);


    }
}
