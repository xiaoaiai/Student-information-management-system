package jdbc;

import java.sql.*;
import java.util.*;
import xinxi.*;

public class CourseDao extends BaseDao{
	 public List<Course> select() throws Exception{
    	 List<Course> li=new ArrayList<Course>();
    	 Connection conn=this.initConnection();
    	 String sql="select * from course";
    	 ResultSet rs=this.executeQuery(conn, sql);
    	 while(rs.next()){
    		 Course c=new Course();
    	     c.setId(rs.getInt(1));
    	     c.setTeacher(rs.getString(2));
    	     c.setCname(rs.getString(3));
    	     c.setClasshours(rs.getInt(4));
    	     c.setLimitnum(rs.getInt(5));
    	     c.setSelectnum(rs.getInt(6));
    	     li.add(c);
    	 }
    	 return li;
     }
	 
	 public ResultSet find(String cname) throws Exception{
		 String sql="select * from course where name='"+cname+"' ";
		 ResultSet rs=null;
		 Connection conn=this.initConnection();
		 rs=this.executeQuery(conn, sql);
		 return rs;
	 }
	 public int saveinsert(Course c) throws Exception{
		 Connection conn=this.initConnection();
		 String sql="insert into course values("+c.getId()+",'"+c.getTeacher()+"','"+c.getCname()+"',"+c.getClasshours()+","+c.getLimitnum()+","+c.getSelectnum()+")";
		 int count=0;
		 count=this.executeupdate(conn, sql);
		 return count;
	 }
	 
	 public int savedelete(Course c) throws Exception{
		 Connection conn=this.initConnection();
		 String sql="delete from course where name='"+c.getCname()+"'";
		 int count=0;
		 count=this.executeupdate(conn, sql);
		 return count;
	 }
	 
	 public int saveupdate(Course c,String name) throws Exception{
		 Connection conn=this.initConnection();
		 String sql="update course set id="+c.getId()+",teacher='"+c.getTeacher()+"',name='"+c.getCname()+"',classhours="+c.getClasshours()+",limitnum="+c.getLimitnum()+",selectnum="+c.getSelectnum()+" where name='"+name+"'";
		 int count=0;
		 count=this.executeupdate(conn, sql);
		 return count;
	 }
}
