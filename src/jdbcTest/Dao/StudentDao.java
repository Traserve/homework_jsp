package jdbcTest.Dao;

import java.sql.*;

/**
 * Created by online on 15-1-24.
 */
public class StudentDao {
    //链接数据库
    public static Connection getConne(){
        Connection con = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/ourschool?"+
                "user=root&password=p5385676&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url);
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String getOwner(String login) {//获得该生的编号
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String id =null;
        try {
            con = getConne();
            stmt = con.createStatement();
            String sql = null;
            sql = "select id from students where sid = "+login+";";
            //查询学生信息
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                id = rs.getString(1);
                System.out.println(id);
            }
        }
        catch (Exception ex){
            System.out.println("Error : " + ex.toString());
        }finally {

            closeAll(rs, stmt, con);

        }
        return id;
    }
    public static boolean studentLogin(String login) {//查
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        int i =0;
        String str = null;
        try {
            con = getConne();
            stmt = con.createStatement();
            String sql = null;
            sql = "select sname,id from students where sid = "+login+";";
            //查询学生信息
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                i++;
                String sname = rs.getString(1);
                str = sname;
            }
        }
        catch (Exception ex){
            System.out.println("Error : " + ex.toString());
        }finally {

            closeAll(rs, stmt, con);
            if (i>0){
                return true;
            }
            return false;
        }

    }
    public static void insertInfo(int id,String name){//增
        Connection con = null;
        Statement stmt=null;
        try {
            con = getConne();
            stmt =  con.createStatement();
            String sql=null;
            sql = "insert into students(sid,sname) values("+id+",'"+name+"');";
            //写入学生信息.
            int sr = stmt.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("Error : " + ex.toString());
        }
        finally {
            closeAll(null,stmt,con);
        }
    }

    public static String searchInfo() {//查
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String str = "<table border=\"1\" bordercolor=\"blue\" cellpadding=\"10\" cellspacing=\"0\" width=\"500\">" +
                "<tr><th>序号</th><th>学号</th><th>姓名</th></tr>";
        try {
            con = getConne();
            stmt = con.createStatement();

            String sql = null;
            sql = "select *from students";
            //查询学生信息
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id = rs.getString(1);
                String sid = rs.getString(2);
                String sname = rs.getString(3);
                str = str+"<tr><th>"+id+"</th><th>"+sid+"</th><th>"+sname+"</th></tr>";
            }
            str = str+"</table>";
        }
        catch (Exception e){
            System.out.println("Error : " + e.toString());
        }finally {
            closeAll(rs, stmt, con);
            return str;
        }

    }
    public static void closeAll(ResultSet rs,Statement stmt,Connection con){
        try{
            if(rs!=null)
                rs.close();
            if (stmt!=null)
                stmt.close();

            if (con!=null)
                con.close();
        } catch (Exception ex) {
            System.out.println("Error : " + ex.toString());
        }
    }
}
