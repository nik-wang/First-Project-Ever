package foreignWorker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Util.ConnectionUtil;

public class TestAddData {
	
	public static void addData() {
		String sql = "INSERT INTO [dbo].[justatest]" + "([country], [agencyID], [agencyName], [phoneNumber])"
				+ "VALUES (?,?,?,?)";
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try(Connection connection = connectionUtil.getConnection()){
			connection.setAutoCommit(false);
			try(PreparedStatement stmt = connection.prepareStatement(sql)){
			for (int i=0; i<30; i++) {
				stmt.setString(1, "country"+i);
				stmt.setString(2, "ID"+i);
				stmt.setString(3, "12345");
				stmt.setString(4, "asdfg");
				stmt.addBatch();
				if (i%20 == 0) {
					stmt.executeBatch();
					
				}
				stmt.executeBatch();
			}
			} catch(SQLException e) {
				connection.rollback();
				e.printStackTrace();
			}
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		addDataTest.addData();
//		System.out.println("OK");
	}

}
