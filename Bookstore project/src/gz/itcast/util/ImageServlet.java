package gz.itcast.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

public class ImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        //生成一张随机验证码图片，并写出到浏览器
        OutputStream out = response.getOutputStream();
        String sCode = ValidateCodeUtils.genNewCode(out);
        //将sCode共享给用户登录时使用
        session.setAttribute("sCode",sCode);




    }
}
