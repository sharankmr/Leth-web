import java.util.*;  
import java.sql.*;  

public class EmpDao {  

	public static Connection getConnection(){  
		Connection con=null;  
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/leather","root","root");  
		}catch(Exception e){System.out.println(e);}  
		return con;  
	}  
	public static int save(Emp e){  
		int status=0;  
		try{  
			Connection con=EmpDao.getConnection();  
			PreparedStatement ps=con.prepareStatement("insert into user905(id,product,quantity,value) values (?,?,?,?)"); 
			ps.setInt(1,e.getid());
			ps.setString(2,e.getproduct());  
			ps.setInt(3,e.getquantity());  
			ps.setInt(4,e.getvalue());  


			status=ps.executeUpdate();  

			con.close();  
		}catch(Exception ex){ex.printStackTrace();}  

		return status;  
	}  
	public static int update(Emp e){  
		int status=0;  
		try{  
			Connection con=EmpDao.getConnection();  
			PreparedStatement ps=con.prepareStatement("update user905 set product=?,quantity=?,value=? where id=?");  
			ps.setString(1,e.getproduct());  
			ps.setInt(2,e.getquantity());  
			ps.setInt(3,e.getvalue());  
			ps.setInt(4,e.getid());

			status=ps.executeUpdate();  

			con.close();  
		}catch(Exception ex){ex.printStackTrace();}  

		return status;  
	}  
	public static int delete(int id){  
		int status=0;  
		try{  
			Connection con=EmpDao.getConnection();  
			PreparedStatement ps=con.prepareStatement("delete from user905 where id=?");  
			ps.setInt(1,id);  
			status=ps.executeUpdate();  

			con.close();  
		}catch(Exception e){e.printStackTrace();}  

		return status;  
	}  
	public static Emp getById(int id){  
		Emp e=new Emp();  

		try{  
			Connection con=EmpDao.getConnection();  
			PreparedStatement ps=con.prepareStatement("select * from user905 where id=?");  
			ps.setInt(1,id);  
			ResultSet rs=ps.executeQuery();  
			if(rs.next()){  
				e.setid(rs.getInt(1));
				e.setproduct(rs.getString(2));  
				e.setquantity(rs.getInt(3));  
				e.setvalue(rs.getInt(4));  

			}  
			con.close();  
		}catch(Exception ex){ex.printStackTrace();}  

		return e;  
	}  
	public static List<Emp> getAllrecords(){  
		List<Emp> list=new ArrayList<Emp>();  

		try{  
			Connection con=EmpDao.getConnection();  
			PreparedStatement ps=con.prepareStatement("select * from user905");  
			ResultSet rs=ps.executeQuery();  
			while(rs.next()){  
				Emp e=new Emp();  
				e.setid(rs.getInt(1));
				e.setproduct(rs.getString(2));  
				e.setquantity(rs.getInt(3));  
				e.setvalue(rs.getInt(4));  
				list.add(e);  
			}  
			con.close();  
		}catch(Exception e){e.printStackTrace();}  

		return list;  
	}  
}  