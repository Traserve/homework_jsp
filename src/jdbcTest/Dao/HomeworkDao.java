package jdbcTest.Dao;

import jdbcTest.Model.Homework;

import java.sql.*;

/**
 * Created by online on 15-1-24.
 */
public class HomeworkDao {
    public static void teacherCorrectingHomework(String score1,String homeworkid1,String stuid1){
        Connection con = null;
        Statement stmt=null;
         int score =Integer.parseInt(score1) ;
         int homeworkid =Integer.parseInt(homeworkid1) ;
         int stuid =Integer.parseInt(stuid1) ;
        try {
            con = StudentDao.getConne();
            stmt = con.createStatement();
            String sql = "update students s,homeworks h set score="+score+" where s.sid ="+ stuid+" and s.id = h.owner and h.homeworkid="+homeworkid+";";

            stmt.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("Error : " + ex.toString());
        }
        finally {
            StudentDao.closeAll(null, stmt, con);
        }
    }
    public static void insertInfo_homework(String hid1,String ans,String owner1){//增
        Connection con = null;
        PreparedStatement stmt=null;
        Homework h = new Homework();
        int hid = Integer.parseInt(hid1);
        int owner = Integer.parseInt(owner1);
        try {
            h.setAnswer(ans);
            h.setHomeworkid(hid);
            h.setowner(owner);
            con = StudentDao.getConne();
            String sql = "insert into homeworks(homeworkid,answer,owner) values(?,?,?);";
            //学生提交作业，成绩为空
            stmt =  con.prepareStatement(sql);
            stmt.setInt(1,h.getHomeworkid());
            stmt.setString(2,h.getAnswer());
            stmt.setInt(3,h.getowner());
            stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error : " + ex.toString());
        }
        finally {
            StudentDao.closeAll(null, stmt, con);
        }
    }
    public static String searchBySidNoscore(int stuid) {//查作业信息
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String str ="<table border=\"1\" bordercolor=\"blue\" cellpadding=\"10\" cellspacing=\"0\" width=\"500\">" +
                "<tr><th>作业编号</th><th>答案</th></tr>";
        int i=0;
        try {
            con = StudentDao.getConne();
            stmt = con.createStatement();
            String sql = null;
            sql = "select homeworkid,answer from students s,homeworks h where s.sid ="+ stuid+" and s.id = h.owner and score is null ;";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                i++;
                String answer = rs.getString(2);
                Integer homeworkid = rs.getInt(1);
               str = str+"<tr><th>"+homeworkid+"</th><th>"+answer+"</th></tr>";
            }
            str+="</table>";
        } catch (Exception e) {
            System.out.println("Error : " + e.toString());
        } finally {
            StudentDao.closeAll(rs, stmt, con);
            if (i==0){
                str = "该生作业都已批改完毕。";}
            return str;
        }
    }
    public static String searchBySid(String stuids) {//查学生的作业信息
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String str = "<table border=\"1\" bordercolor=\"blue\" cellpadding=\"10\" cellspacing=\"0\" width=\"500\">" +
                "<tr><th>作业编号</th><th>答案</th><th>序号</th><th>分数</th></tr>";
        int stuid = Integer.parseInt(stuids);
        try {
            con = StudentDao.getConne();
            stmt = con.createStatement();
            String sql = "";
            sql = "select homeworkid,answer,owner,score from students s,homeworks h where s.sid ="+ stuid+" and s.id = h.owner;";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String answer = rs.getString(2);
                Integer homeworkid = rs.getInt(1);
                Integer owner = rs.getInt(3);
                Integer score = rs.getInt(4);
                str+="<tr><th>"+homeworkid+"</th><th>"+answer+"</th><th>"+owner+"</th><th>"+score+"</th></tr>";
            }
            str+="</table>";
        } catch (Exception e) {
            System.out.println("Error : " + e.toString());
        } finally {
            StudentDao.closeAll(rs, stmt, con);
            return str;
        }
    }
    public static String  searchByOwner(String owner1) {//查学生的作业信息
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String str = "<table border=\"1\" bordercolor=\"blue\" cellpadding=\"10\" cellspacing=\"0\" width=\"500\">" +
                "<tr><th>序号</th><th>学号</th><th>姓名</th><th>作业编号</th><th>分数</th></tr>";
        int owner = Integer.parseInt(owner1);
        try {
            con = StudentDao.getConne();
            stmt = con.createStatement();
            String sql = null;
            sql = "select * from students s,homeworks h where h.owner ="+ owner+" and s.id = h.owner;";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Integer sid = rs.getInt(2);
                Integer id = rs.getInt(1);
                String sname = rs.getString(3);
                Integer homeworkid = rs.getInt(5);
                Integer score = rs.getInt(8);

                str=str+"<tr><th>"+id+"</th><th>"+sid+"</th><th>"+sname+"</th><th>"+homeworkid+"</th><th>"+score+"</tr>";
            }
            str = str+"</table>";
        } catch (Exception e) {
            System.out.println("Error : " + e.toString());
        } finally {
            StudentDao.closeAll(rs, stmt, con);
            return str;
        }
    }
    public static String  searchByNoscore(){//查未批改的作业的学生信息
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String str ="<table border=\"1\" bordercolor=\"blue\" cellpadding=\"10\" cellspacing=\"0\" width=\"500\">" +
                "<tr><th>姓名</th><th>学号</th></tr>";
        try {
            con = StudentDao.getConne();
            stmt = con.createStatement();
            String sql = null;
            sql = "select distinct sid,sname from students s,homeworks h where h.score is NULL and s.id = h.owner;";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String sname = rs.getString(2);
                Integer sid = rs.getInt(1);
                str = str+"<tr><th>"+sname+"</th><th>"+sid+"</th></tr>";
            }
            str=str+"</table>";
        } catch (Exception e) {
            System.out.println("Error : " + e.toString());
        } finally {
            StudentDao.closeAll(rs, stmt, con);
            return str;
            }
        }

}
