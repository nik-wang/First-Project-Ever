package foreignWorker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Util.ConnectionUtil;
import foreignWorker.bean.HRAgency;

public class TestLargeInsertData {

	public void importlargedata(List<HRAgency> hrAgencyDataList) {
		String sql = "INSERT INTO [dbo].[humanResourceAgency]" + "([country], [agencyID], [agencyName], [phoneNumber],"
				+ "[address], [effectiveDate], [expirationDate])"
				// Parse string into date, 112 means ISO Date yyyymmdd.
				+ "VALUES (?,?,?,?,?,convert(Date,?,112),convert(Date,?,112))";
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) {
			// Set auto-commit to false
			connection.setAutoCommit(false);
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				int count = 0;
				for (HRAgency hrAgency : hrAgencyDataList) {
					statement.setString(1, hrAgency.getCountry());
					statement.setString(2, hrAgency.getAgencyId());
					statement.setString(3, hrAgency.getAgencyName());
					statement.setString(4, hrAgency.getPhoneNumber());
					statement.setString(5, hrAgency.getAddress());
					statement.setString(6, hrAgency.getEffectiveDate());
					statement.setString(7, hrAgency.getExpirationDate());
					// Add Batch
					statement.addBatch();
					count++;

					// Execute batch every 200 records
					if (count % 200 == 0) {
						statement.executeBatch();
					}
				}
				// Execute any remaining batches
				statement.executeBatch();
				// Commit the transaction
				connection.commit();
			} catch (SQLException e) {
				connection.rollback();
				e.printStackTrace();
			} finally {
				// Set auto-commit back to true
				connection.setAutoCommit(true);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return false;
	}

}
