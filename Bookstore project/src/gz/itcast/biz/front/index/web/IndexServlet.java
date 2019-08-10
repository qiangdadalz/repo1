package gz.itcast.biz.front.index.web;

import gz.itcast.biz.front.index.service.IndexService;
import gz.itcast.biz.front.index.service.IndexServiceImpl;
import gz.itcast.entity.Books;
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

    /**
     根据分类id显示图书信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     *  /index?action=queryBooks
     */
    public void queryBooks(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        //获取用户传过来的分类id
        String typeId = request.getParameter("typeId");
        //通过分类id获取分类的数据
        List<Books> books = service.queryBooks(typeId);
        //将数据转到jsp页面
        request.setAttribute("books",books);
        request.getRequestDispatcher("/jsp/front/book/list.jsp").forward(request,response);

    }

    /**
     * 根据id查询对应的图书详细
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * /index?action=queryBook&id=xxx
     */
    public void queryBook(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        String id = request.getParameter("id");
        Books books = service.queryBook(id);
        request.setAttribute("book",books);
        request.getRequestDispatcher("/jsp/front/book/detail.jsp").forward(request,response);
    }
}
