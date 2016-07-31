package jdbc;

import java.sql.*;
import java.util.*;
import xinxi.*;

public class CadminDao extends BaseDao{
     public List<Cadmin> select() throws Exception{
    	 List<Cadmin> li=new ArrayList<Cadmin>();
    	 Connection conn=this.initConnection();
    	 String sql="select * from cadmin";
    	 ResultSet rs=this.executeQuery(conn, sql);
    	 while(rs.next()){
    		 Cadmin c=new Cadmin();
    	     c.setName(rs.getString(1));
    	     c.setPassword(rs.getString(2));
    	     li.add(c);
    	 }
    	 return li;
     }
     
     public int saveinsert(Cadmin c) throws Exception{
		 Connection conn=this.initConnection();
		 String sql="insert into cadmin values('"+c.getName()+"','"+c.getPassword()+"')";
		 int count=0;
		 count=this.executeupdate(conn, sql);
		 return count;
	 }
	 
	 public int savedelete(Cadmin c) throws Exception{
		 Connection conn=this.initConnection();
		 String sql="delete from cadmin where name='"+c.getName()+"'";
		 int count=0;
		 count=this.executeupdate(conn, sql);
		 return count;
	 }
	 
	 public int saveupdate(Cadmin c,String name) throws Exception{
		 Connection conn=this.initConnection();
		 String sql="update cadmin set name='"+c.getName()+"',password='"+c.getPassword()+"' where name='"+name+"'";
		 int count=0;
		 count=this.executeupdate(conn, sql);
		 return count;
	 }
}
