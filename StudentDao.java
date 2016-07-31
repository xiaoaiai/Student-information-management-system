package jdbc;

import java.sql.*;
import java.util.*;
import xinxi.*;

public class StudentDao extends BaseDao{
	 public List<Student> select() throws Exception{
    	 List<Student> li=new ArrayList<Student>();
    	 Connection conn=this.initConnection();
    	 String sql="select * from student";
    	 ResultSet rs=this.executeQuery(conn, sql);
    	 while(rs.next()){
    		 Student s=new Student();
    	     s.setStunum(rs.getString(1));
    	     s.setName(rs.getString(2));
    	     s.setSex(rs.getString(3));
    	     s.setPassword(rs.getString(4));
    	     s.setAddress(rs.getString(5));
    	     s.setIdentitycard(rs.getString(6));
    	     s.setClassname(rs.getString(7));
    	     li.add(s);
    	 }
    	 return li;
     }
	 
	 public int saveinsert(Student s) throws Exception{
		 Connection conn=this.initConnection();
		 String sql="insert into student values('"+s.getStunum()+"','"+s.getName()+"','"+s.getSex()+"',"+s.getPassword()+",'"+s.getAddress()+"','"+s.getIdentitycard()+"','"+s.getClassname()+"')";
		 int count=0;
		 count=this.executeupdate(conn, sql);
		 return count;
	 }
	 
	 public int savedelete(Student s) throws Exception{
		 Connection conn=this.initConnection();
		 String sql="delete from student where name='"+s.getName()+"'";
		 int count=0;
		 count=this.executeupdate(conn, sql);
		 return count;
	 }
	 
	 public int saveupdate(Student s,String name) throws Exception{
		 Connection conn=this.initConnection();
		 String sql="update student set stunum='"+s.getStunum()+"',name='"+s.getName()+"',sex='"+s.getSex()+"',password='"+s.getPassword()+"',address='"+s.getAddress()+"',identitycard='"+s.getIdentitycard()+"',class='"+s.getClassname()+"' where name='"+name+"'";
		 int count=0;
		 count=this.executeupdate(conn, sql);
		 return count;
	 }
	 public Student loadPage(Student s) throws Exception{
		    Student st=null;
			Connection conn=this.initConnection();
			String sql="select * from student where name='"+s.getName()+"' and password='"+s.getPassword()+"'";
			ResultSet rs=this.executeQuery(conn, sql);
			while(rs.next()&&rs!=null){
				st=new Student();
				String name=rs.getString(2);
				String pass=rs.getString(4);
				st.setName(name);
				st.setPassword(pass);
			}
			conn.close();
			return st;
		}
	 public ResultSet find(String name) throws Exception{
		 Connection conn=this.initConnection();
		 String sql="select * from student where name='"+name+"'";
		 ResultSet rs=this.executeQuery(conn, sql);
		 return rs;
	 }
}
