package homeworkDemo;

import jdbcTest.Dao.HomeworkDao;
import jdbcTest.Dao.StudentDao;
import jdbcTest.IMG.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * Created by online on 15-1-26.
 */
@WebServlet(urlPatterns = "/login", name = "stuLogin")
public class Homework extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("hid_1") != null && req.getParameter("answer1") != null) {//第四次请求
            HttpSession hs = req.getSession();
            String hid = req.getParameter("hid_1");
            String answer = req.getParameter("answer1");
            String owner = StudentDao.getOwner((String) hs.getAttribute("sid"));
            HomeworkDao.insertInfo_homework(hid, answer, owner);
            req.getRequestDispatcher("/insertHomework.jsp").forward(req, resp);
        } else if (req.getParameter("hid") != null && req.getParameter("score") != null) {//第三次请求
            HttpSession hs = req.getSession();
            String stuid = (String) hs.getAttribute("stuid_1");//只要网页没有关闭，次session会保留
            String hid = req.getParameter("hid");
            String score = req.getParameter("score");
            HomeworkDao.teacherCorrectingHomework(score, hid, stuid);
            req.setAttribute("stuid2", stuid);//可以设置请求参数，当转网页的时候  因为会把req传到下一个网页，形成交互
            req.getRequestDispatcher("/getHomework.jsp").forward(req, resp);
        } else if (req.getParameter("stuid1") != null) {//第二次请求
            HttpSession hs = req.getSession();
            if (!req.getParameter("stuid1").equals("") && req.getParameter("stuid") != null) {
                hs.setAttribute("stuid_1", req.getParameter("stuid1"));//设置session
            } else {
                resp.setCharacterEncoding("UTF-8");//编码
                req.setAttribute("cuowu1", "cuo");
                req.getRequestDispatcher("/searchByNoscore.jsp").forward(req, resp);
            }
            String stuid = (String) hs.getAttribute("stuid_1");
            if (req.getParameter("stuid").equals("2") && stuid != null && !stuid.equals("")) {
                req.setAttribute("stuid2", stuid);
                req.getRequestDispatcher("/searchHomework.jsp").forward(req, resp);
            } else if (req.getParameter("stuid").equals("1") && stuid != null && !stuid.equals("")) {
                req.setAttribute("stuid2", stuid);
                req.getRequestDispatcher("/getHomework.jsp").forward(req, resp);
            } else {
                resp.setCharacterEncoding("UTF-8");//编码
                req.setAttribute("cuowu1", "cuo");
                req.getRequestDispatcher("/searchByNoscore.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //第一次需要输入文本的时候，因为不这样的话第二次请求依然会判断req.getParameter("sid") 引起错误
        HttpSession session = req.getSession();//创建session对象
        String para = req.getParameter("sid");
        String str = null;

        /**
         * 判断用户输入的验证码是否匹配
         */
        String sessCode = (String)req.getSession().getAttribute("verfi");
        String verfiCode=req.getParameter("verfi");
        if (!sessCode.equalsIgnoreCase(verfiCode)){
            req.setAttribute("cuowu", "cuo");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);//跳转页面
            return;
        }

        if (req.getParameter("login") != null) {
            if (req.getParameter("login").equals("1")) {
                req.getRequestDispatcher("/intoTeacher.jsp").forward(req, resp);
            } else if (req.getParameter("login").equals("2") && StudentDao.studentLogin(para)) {
                session.setAttribute("sid", req.getParameter("sid"));//设置键值对
            }
        }
        str = (String) session.getAttribute("sid");//获得键为sid 的值
        if (str == null || str.equals("") || req.getParameter("login") == null || req.getParameter("login").equals("")) {
            resp.setCharacterEncoding("UTF-8");//编码
            req.setAttribute("cuowu", "cuo");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);//跳转页面
            return;
        } else {
            req.getRequestDispatcher("/intoStudent.jsp").forward(req, resp);
        }
    }
}

