package homeworkDemo;

import jdbcTest.IMG.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by online on 15-2-5.
 */
@WebServlet(urlPatterns = "/verfi",name = "ver")
public class Verfi extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 使用验证码  防止暴力登录。无限访问  导致服务器瘫痪
         */
        VerifyCode ver = new VerifyCode();
        BufferedImage bi = ver.getImage();
        req.getSession().setAttribute("verfi",ver.getText());
        VerifyCode.output(bi,resp.getOutputStream());
    }
}
