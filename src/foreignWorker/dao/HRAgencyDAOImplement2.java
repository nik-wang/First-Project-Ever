package foreignWorker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Util.ConnectionUtil;
import foreignWorker.bean.HRAgency;

public class HRAgencyDAOImplement2 {
//implements HRAgencyDAO {

//	@Override
	public void saveHRAgnecy(List<HRAgency> hrAgencyDataList) {
		String sql = "INSERT INTO [dbo].[humanResourceAgency]" + "([country], [agencyID], [agencyName], [phoneNumber],"
				+ "[address], [effectiveDate], [expirationDate])"
				+ "VALUES (?,?,?,?,?,convert(Date,?,112),convert(Date,?,112))"; //Parse string into date, 112 =ISO Date yyyymmdd
		ConnectionUtil connectionUtil = new ConnectionUtil();

		try (Connection connection = connectionUtil.getConnection()) {

			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				// Set auto-commit to false
				connection.setAutoCommit(false);
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
			e.printStackTrace();
		}

	}

//	@Override
	public boolean addHRAgency(HRAgency hrAgency) {
		String sql = "INSERT INTO [dbo].[humanResourceAgency]" + "([country], [agencyID], [agencyName], [phoneNumber],"
				+ "[address], [effectiveDate], [expirationDate])"
				+ "VALUES (?,?,?,?,?,convert(Date,?,112),convert(Date,?,112))"; //Parse string into date, 112 =ISO Date yyyymmdd
		ConnectionUtil connectionUtil = new ConnectionUtil();
		int countOfUpdate = 0;

		try (Connection connection = connectionUtil.getConnection()) {
			// Set auto-commit to false
			connection.setAutoCommit(false);

			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, hrAgency.getCountry());
				statement.setString(2, hrAgency.getAgencyId());
				statement.setString(3, hrAgency.getAgencyName());
				statement.setString(4, hrAgency.getPhoneNumber());
				statement.setString(5, hrAgency.getAddress());
				statement.setString(6, hrAgency.getEffectiveDate());
				statement.setString(7, hrAgency.getExpirationDate());
				statement.executeUpdate();
				// Commit the transaction
				connection.commit();
			} catch (SQLException e) {
				connection.rollback();
				e.printStackTrace();
			} finally {
				// Set auto-commit back to true
				connection.setAutoCommit(true);
			}
			return countOfUpdate > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

//	@Override
	public HRAgency getHRAgencyByPrimaryKey(String country, String agencyID) {

		return null;
	}

//	@Override
	public List<HRAgency> getAllHRAgency() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
	public List<HRAgency> getHRAgencyStillEffective() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
	public List<HRAgency> getHRAgencyByAddressPatternMatch(String location) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
	public boolean updateHRAgency(HRAgency hrAgency) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
	public boolean deleteHRAgency(String country, String agencyID) {
		// TODO Auto-generated method stub
		return false;
	}



}
