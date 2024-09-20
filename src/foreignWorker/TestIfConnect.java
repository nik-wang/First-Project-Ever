package foreignWorker;

import java.sql.Connection;
//import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Util.ConnectionUtil;

public class TestIfConnect {

	public static void main(String[] args) {
		String sql = "insert into humanResourceAgency(country, agencyID, agencyName, effectiveDate, expirationDate)"
				+ "values(?,?,?,convert(Date,?,112),convert(Date,?,112))";
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
//			ResultSet resultSet = statement.executeQuery();
//			while (resultSet.next()) {
			statement.setString(1, "\'V\'");
			statement.setString(2, "\'A-2\'");
			statement.setString(3, "\'AAA\'");
			statement.setString(4, "20111001");
//						.DateTimeFormatter.BASIC_ISO_DATE
			statement.setString(5, "20240501");
			int countOfUpdate = statement.executeUpdate();
			System.out.println(countOfUpdate);

//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
