package com.essayvote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class voteDB {
	private boolean isvoted;
	private boolean issubscribed;
	private String hasidentity;
	private String dbUser = "root";
	private String dbPwd = "adminwebdata";
	private String dbUrl = "jdbc:mysql://121.40.84.119:3306/EssayVote?user="+dbUser+"&password="+dbPwd+"&useUnicode=true&characterEncoding=gb2312";
	public voteDB() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
	}
	public Connection getConnection() throws Exception {
		return java.sql.DriverManager.getConnection(dbUrl);
		//return  ds.getConnection();	
	}
	
	public void closeConnection(Connection con) {
		try {
			if (con!=null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closePrepStmt(PreparedStatement prepStmt) {
		try {
			if (prepStmt!=null) {
				prepStmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeResultSet(ResultSet rs) {
		try {
			if (rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//鎶曠エ	
//	public boolean vote(String id) {
//		Connection con = null;
//		PreparedStatement prepStmt = null;
//		//ResultSet rs = null;
//		try {
//			con = getConnection();
//			String insert_sql = "UPDATE count SET counts = counts + 1 WHERE id = "+id;
//			prepStmt = con.prepareStatement(insert_sql);
//			prepStmt.execute();
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.print(e);
//		}finally{
//			//closeResultSet(rs);
//			closePrepStmt(prepStmt);
//			closeConnection(con);
//		}
//		return true;
//	}
////是否关注公众号
	public boolean issubscribed(String openid) {
		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;	
		try {
			con = getConnection();
			String select_sql = "select * from openidList where OPENID = '"+openid+"'";
			prepStmt = con.prepareStatement(select_sql);
			rs = prepStmt.executeQuery();
			issubscribed = rs.next();
			//System.out.print(issubscribed);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}finally{
			closeResultSet(rs);
			closePrepStmt(prepStmt);
			closeConnection(con);		
		}
		return issubscribed;
	}
	
	public String hasidentity(String openid) {
		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;	
		try {
			con = getConnection();
			String select_sql = "SELECT CODE FROM `openidList` WHERE OPENID='" + openid + "'";
			prepStmt = con.prepareStatement(select_sql);
			rs = prepStmt.executeQuery();
			if (rs.next()) {
				hasidentity = rs.getString("CODE");	
			}
			//System.out.println(hasidentity);
			//System.out.print(issubscribed);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}finally{
			closeResultSet(rs);
			closePrepStmt(prepStmt);
			closeConnection(con);		
		}
		return hasidentity;
	}
	//修改为其他身份
		public void other(String openid) {
			Connection con = null;
			PreparedStatement prepStmt = null;
			ResultSet rs = null;	
			try {
				con = getConnection();
				String update_sql = "UPDATE openidList SET CODE = '2' WHERE OPENID='" + openid + "';";
				prepStmt = con.prepareStatement(update_sql);
				prepStmt.execute(update_sql);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.print(e);
			}finally{
				closeResultSet(rs);
				closePrepStmt(prepStmt);
				closeConnection(con);		
			}
		}
	//修改为律师身份
	public void lawyer(String openid) {
		Connection con = null;
		PreparedStatement prepStmt = null;
		ResultSet rs = null;	
		try {
			con = getConnection();
			String select_sql = "select * from openidList where OPENID = '"+openid+"'";
			prepStmt = con.prepareStatement(select_sql);
			rs = prepStmt.executeQuery();
			issubscribed = rs.next();
			//System.out.print(issubscribed);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}finally{
			closeResultSet(rs);
			closePrepStmt(prepStmt);
			closeConnection(con);		
		}
	}
////鏌ヨ鐢ㄦ埛涓�ぉ涔嬪唴鏄惁宸叉姇杩囩エ	
//	public boolean isvoted(String openid,String time0,String time1) {
//		Connection con = null;
//		PreparedStatement prepStmt = null;
//		ResultSet rs = null;	
//		try {
//			con = getConnection();
//			String select_sql = "SELECT * FROM voted WHERE openid='"+openid+"' AND time BETWEEN '"+time0+"' AND '"+time1+"'";
//			prepStmt = con.prepareStatement(select_sql);
//			rs = prepStmt.executeQuery();
//			isvoted = rs.next();
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.print(e);
//		}finally{
//			closeResultSet(rs);
//			closePrepStmt(prepStmt);
//			closeConnection(con);		
//		}
//		return isvoted;
//	}
////娣诲姞鎶曠エ璁板綍	
//	public boolean record(String openid,String id,String ip,String useragent,String time) {
//		Connection con = null;
//		PreparedStatement prepStmt = null;
//		//ResultSet rs = null;
//		try {
//			con = getConnection();
//			String insert_sql = "insert into voted values('" + openid + "','" + id + "','"+ ip + "','"+ useragent +"','"+ time +"')";
//			prepStmt = con.prepareStatement(insert_sql);
//			prepStmt.execute();
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.print(e);
//		}finally{
//			//closeResultSet(rs);
//			closePrepStmt(prepStmt);
//			closeConnection(con);
//		}
//		return true;
//	}
////鍙栨瘡涓汉鐨勭エ鏁�
//	public ArrayList getcount() {
//		Connection con = null;
//		PreparedStatement prepStmt = null;
//		ResultSet rs = null;
//		ArrayList arr =new ArrayList();
//		try {
//			con = getConnection();
//			String select_sql = "SELECT counts FROM count";
//			prepStmt = con.prepareStatement(select_sql);
//			rs = prepStmt.executeQuery();
//			while(rs.next()){
//			arr.add(rs.getString(1));
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.print(e);
//		}finally{
//			//closeResultSet(rs);
//			closePrepStmt(prepStmt);
//			closeConnection(con);
//		}
//		return arr;
//	}
//	
//	public String gettoken(){
//		String token="";
//		Date currDate = Calendar.getInstance().getTime();
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    	String dateTime = sdf.format(currDate);
//    	Connection con = null;
//		PreparedStatement prepStmt = null;
//		ResultSet rs = null;
//		try {
//			con = getConnection();
//			String select_sql1 = "SELECT accesstoken FROM token";
//			prepStmt = con.prepareStatement(select_sql1);
//			rs = prepStmt.executeQuery();
//			token = rs.getString(1);
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.print(e);
//		}finally{
//			//closeResultSet(rs);
//			closePrepStmt(prepStmt);
//			closeConnection(con);
//		}
//		String json11 = wx.getContent("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx8ed536ef6dcbf17d&secret=96ebad09c2117c1675986be73c6bc3ef");
//    	JSONTokener tokener11 = new JSONTokener(json11);
//    	JSONObject object11 = (JSONObject)tokener11.nextValue();
//    	token = object11.getString("access_token");
//		return token;
//	}
//	
//	public String token() {
//		Connection con = null;
//		PreparedStatement prepStmt = null;
//		ResultSet rs = null;
//		String token="";
//		try {
//			con = getConnection();
//			String select_sql1 = "SELECT accesstoken FROM token";
//			prepStmt = con.prepareStatement(select_sql1);
//			rs = prepStmt.executeQuery();
//			token = rs.getString(1);
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.print(e);
//		}finally{
//			closeResultSet(rs);
//			closePrepStmt(prepStmt);
//			closeConnection(con);
//		}
//		return token;
//	}
}
