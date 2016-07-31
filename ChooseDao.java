package jdbc;
import java.sql.*;
import java.util.*;

import xinxi.*;

public class ChooseDao extends BaseDao{
	 public List<Choose> select() throws Exception{
    	 List<Choose> li=new ArrayList<Choose>();
    	 Connection conn=this.initConnection();
    	 String sql="select * from choose";
    	 ResultSet rs=this.executeQuery(conn, sql);
    	 while(rs.next()){
    		 Choose c=new Choose();
    	     c.setStunum(rs.getInt(1));
    	     c.setName(rs.getString(2));
    	     c.setTeacher(rs.getString(3));
    	     c.setCname(rs.getString(4));
    	     li.add(c);
    	 }
    	 return li;
     }
	 
	 public ResultSet find(String name) throws Exception{
		 Connection conn=this.initConnection();
		 ResultSet rs=null;
		 String sql="select * from choose where name='"+name+"'";
		 rs=this.executeQuery(conn, sql);
		 return rs;
	 }
	 public int saveinsert(Choose c) throws Exception{
		 Connection conn=this.initConnection();
		 String sql="insert into choose values("+c.getStunum()+",'"+c.getName()+"','"+c.getTeacher()+"','"+c.getCname()+"')";
		 int count=0;
		 count=this.executeupdate(conn, sql);
		 return count;
	 }
	 
	 public int savedelete(Choose c) throws Exception{
		 Connection conn=this.initConnection();
		 String sql="delete from choose where name='"+c.getName()+"'";
		 int count=0;
		 count=this.executeupdate(conn, sql);
		 return count;
	 }
	 
	 public int saveupdate(Choose c,String name) throws Exception{
		 Connection conn=this.initConnection();
		 String sql="update choose set stunum="+c.getStunum()+",name='"+c.getName()+"',teacher='"+c.getTeacher()+"'cname='"+c.getCname()+"' where name='"+name+"'";
		 int count=0;
		 count=this.executeupdate(conn, sql);
		 return count;
	 }
}
