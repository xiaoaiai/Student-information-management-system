package jdbc;

import java.sql.*;
import java.util.*;

import xinxi.*;

public class GradeDao extends BaseDao{
	 public List<Grade> select() throws Exception{
    	 List<Grade> li=new ArrayList<Grade>();
    	 Connection conn=this.initConnection();
    	 String sql="select * from grade";
    	 ResultSet rs=this.executeQuery(conn, sql);
    	 while(rs.next()){
    		 Grade g=new Grade();
    	     g.setStuname(rs.getString(1));
    	     g.setStuname(rs.getString(2));
    	     g.setCname(rs.getString(3));
    	     g.setStugrade(rs.getInt(4));
    	     li.add(g);
    	 }
    	 return li;
     }
	 
	 public int saveinsert(Grade g) throws Exception{
		 Connection conn=this.initConnection();
		 String sql="insert into grade values('"+g.getStunum()+"','"+g.getStuname()+"','"+g.getCname()+"',"+g.getStugrade()+")";
		 int count=0;
		 count=this.executeupdate(conn, sql);
		 return count;
	 }
	 
	 public int savedelete(Grade g) throws Exception{
		 Connection conn=this.initConnection();
		 String sql="delete from grade where stunum='"+g.getStunum()+"'";
		 int count=0;
		 count=this.executeupdate(conn, sql);
		 return count;
	 }
	 
	 public int saveupdate(Grade g,String name) throws Exception{
		 Connection conn=this.initConnection();
		 String sql="update grade set stunum='"+g.getStunum()+"',stuname='"+g.getStuname()+"',cname='"+g.getCname()+"',stugrade="+g.getStugrade()+" where stuname='"+name+"'";
		 int count=0;
		 count=this.executeupdate(conn, sql);
		 return count;
	 }
	 
}
