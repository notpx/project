package hero;

import java.util.*;
import java.sql.*;

public class DBHandler {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car?characterEncoding=latin1", "root",
					"root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int save(Car e) {
		int status = 0;
		try {
			Connection con = DBHandler.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into parking(slot,owner) values (?,?)");
			ps.setString(1, e.getSlot());
			ps.setString(2, e.getOwner());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public static int update(Car e) {
		int status = 0;
		try {
			Connection con = DBHandler.getConnection();
			PreparedStatement ps = con.prepareStatement("update parking set slot=?,owner=? where id=?");
			ps.setString(1, e.getSlot());
			ps.setString(2, e.getOwner());
			ps.setInt(3, e.getId());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = DBHandler.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from parking where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static Car getEmployeeById(int id) {
		Car e = new Car();
		try {
			Connection con = DBHandler.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from parking where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setSlot(rs.getString(2));
				e.setOwner(rs.getString(3));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}

	public static List<Car> getAllEmployees() {
		List<Car> list = new ArrayList<Car>();
		try {
			Connection con = DBHandler.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from parking");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Car e = new Car();
				e.setId(rs.getInt(1));
				e.setSlot(rs.getString(2));
				e.setOwner(rs.getString(3));

				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}