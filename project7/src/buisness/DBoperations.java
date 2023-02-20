package buisness;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import bean.Student;
import logic.GetData;


public class DBoperations {
	String url="jdbc:mysql://localhost:3306/d1";
	 String id= "root";
	 String pass="ROOT";
	 Connection con ;
	public  Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection(url, id, pass);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	public void insert(Student s1) {
		try {
		Connection con = getConnection();
		Student s = GetData.data();
		PreparedStatement ps = con.prepareStatement("insert into student_d1 value(?,?,?,?)");
		ps.setInt(1, s.getRoll());
		ps.setString(2, s.getName());
		ps.setString(3, s.getBranch());
		ps.setInt(4, s.getSemester());
		ps.execute();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("it works");
	}
	public void getById(int id) {
		try {
			Connection con= getConnection();
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery("select *from student_d1 where roll = '"+id+"'");
			while(rs.next()) {
				System.err.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
				System.out.println();
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("it works");
		
	}
	
	public void getAll(int k) {
		String order;
		if(k==1) {
			order="asc";
		}
		else {
			order="desc";
		}
		try {
			Connection con= getConnection();
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery("select *from student_d1 order by roll "+order);
			while(rs.next()) {
				System.err.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
				
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void main(String[] args) {
		Student s = new Student();
		DBoperations db = new DBoperations();
		db.getConnection();
		Scanner sc = new Scanner(System.in);
		int n=7;
		boolean b =true;
		while(n!=0)
		{
			System.out.println();
			System.out.println("enter 1 for insertion");
			System.out.println("enter 2 to get data by roll");
			System.out.println("enter 3 to get  data sorted in desc order");
			System.out.println("enter 0 to exit");
			n=sc.nextInt();
		
			switch(n) {
			case 1: db.insert(s);
				break;
			case 2: 
			System.out.println("enter roll");
			int r = sc.nextInt();
			db.getById(r);
			break;
			case 3: System.out.println("enter 1 for asc\n2 for desc");
				int k = sc.nextInt(); 
				db.getAll(k);
				break;
		}	
		
	  }
	}
}	
