package Util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WriteCSVUtil {
	public static String writeCSV(String fileName, String condition) {
		
		String sql = 
				"SELECT [country], [agencyID], [agencyName], [phoneNumber],"+
				"[address], [effectiveDate], [expirationDate] FROM [dbo].[humanResourceAgency]";
		sql += condition;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (PrintWriter printWriter = new PrintWriter(fileName);
			Connection connection = connectionUtil.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			// add header
			printWriter
					.write(" ,country, agencyID, agencyName, phoneNumber, address, effectiveDate, expirationDate \n");

			// write data
			while (result.next()) {
				printWriter.write(" ,");
				printWriter.write(result.getString(1) + ",");
				printWriter.write(result.getString(2) + ",");
				printWriter.write(result.getString(3) + ",");
				printWriter.write(result.getString(4) + ",");
				printWriter.write("\"" +result.getString(5) + "\",");
				printWriter.write(result.getString(6) + ",");
				printWriter.write(result.getString(7));
				printWriter.write("\n");
			}
			return "CSV file written successfully.";

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			return "Failed to write CSV file: File not found.";
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return "Failed to write CSV file: SQL error.";

		}

	}
}
