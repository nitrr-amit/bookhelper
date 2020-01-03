package bookhelper.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bookhelper.dao.UserDao;
import bookhelper.pojo.User;
import bookhelper.util.DbUtil;

public class UserDaoImpl implements UserDao{
 
	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	public boolean addUser(User user){
		boolean result=false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DbUtil.getConnection();
			String sql="insert into BookHelper_user_table(name,mobile,email_id,password) values(?,?,?,?)";
			pstmt  = con.prepareStatement(sql);
			pstmt.setString(1,user.getName());
			pstmt.setString(2,user.getMobile_no());
			pstmt.setString(3,user.getEmail_id());
			pstmt.setString(4,user.getPassword());
			int r = pstmt.executeUpdate();
			if(r==1){ 
				result=true;
			}else{
				System.out.println("error in add user");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try {
				DbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;

		
		
		
	}
	public  boolean deleteUser(User user){
		 return false;
		 
		 
		 
	 }
	public User loginValidation(String email_id,String password){
		 User user=null;
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs=null;
		 try{
				con = DbUtil.getConnection();
				String sql="select * from BookHelper_user_table"+" where email_id=? and password=?";
				pstmt  = con.prepareStatement(sql);
				pstmt.setString(1,email_id);
				pstmt.setString(2,password);
				rs  = pstmt.executeQuery();
				if(rs.next()){
					String name =rs.getString("name");
					String mobile= rs.getString("mobile");

					user  =new User();
					user.setName(name);
					user.setMobile_no(mobile);
					user.setEmail_id(email_id);
					
				}
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
				

				
			}finally{
				try {
					DbUtil.closeConnection(con);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return user;

	}
	 
	public boolean isUserExist(User user){
		boolean result=false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try{
			con = DbUtil.getConnection();
			String sql="select * from BookHelper_user_table where email_id=?";
			pstmt  = con.prepareStatement(sql);
			
			pstmt.setString(1,user.getEmail_id());
			
			 rs = pstmt.executeQuery();
			 
			if(rs.next()){ 
				
				result=true;
		    }else{
		    	System.out.println("error in isUser existddd");
		    }
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try {
				DbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;

	}

}
