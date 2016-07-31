package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDao {
	public Connection initConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		Connection conn=DriverManager.getConnection(url,"system","xajz");
		return conn;
	}
	
	public void closeConnection(Connection conn) throws Exception{
		if(conn!=null&&!conn.isClosed()){
			conn.close();
			conn=null;
		}
	}
	
	public int executeupdate(Connection conn,String sql) throws Exception{
		int count=0;
		if(conn!=null&&!conn.isClosed()){
			Statement stm=conn.createStatement();
			count=stm.executeUpdate(sql);
		}
		return count;
	}
	
	public ResultSet executeQuery(Connection conn,String sql) throws Exception{
		ResultSet rs=null;
		if(conn!=null&&!conn.isClosed()){
			Statement stm=conn.createStatement();
			rs=stm.executeQuery(sql);
		}
		return rs;
	}
}
