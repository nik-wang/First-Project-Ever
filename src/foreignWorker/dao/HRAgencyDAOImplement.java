package foreignWorker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Util.ConnectionUtil;
import foreignWorker.bean.HRAgency;

public class HRAgencyDAOImplement implements HRAgencyDAO {
	
	@Override
	public boolean addHRAgency(HRAgency hrAgency) {
		String sql = "INSERT INTO [dbo].[humanResourceAgency]" + "([country], [agencyID], [agencyName], [phoneNumber],"
				+ "[address], [effectiveDate], [expirationDate])"	
				+ "VALUES (?,?,?,?,?,convert(Date,?,112),convert(Date,?,112))"; //Parse string into date, 112 =ISO Date yyyymmdd
		ConnectionUtil connectionUtil = new ConnectionUtil();
		PreparedStatement statement = null;
		try (Connection connection = connectionUtil.getConnection()) {
			statement = connection.prepareStatement(sql);
			statement.setString(1, hrAgency.getCountry());
			statement.setString(2, hrAgency.getAgencyId());
			statement.setString(3, hrAgency.getAgencyName());
			statement.setString(4, hrAgency.getPhoneNumber());
			statement.setString(5, hrAgency.getAddress());
			statement.setString(6, hrAgency.getEffectiveDate());
			statement.setString(7, hrAgency.getExpirationDate());
			int countOfUpdate = statement.executeUpdate();
			return countOfUpdate > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveHRAgnecy(List<HRAgency> hrAgencyDataList) {
		String sql = "INSERT INTO [dbo].[humanResourceAgency]" + "([country], [agencyID], [agencyName], [phoneNumber],"
				+ "[address], [effectiveDate], [expirationDate])"
				+ "VALUES (?,?,?,?,?,convert(Date,?,112),convert(Date,?,112))"; //Parse string into date, 112 =ISO Date yyyymmdd
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
			e.printStackTrace();
		}

	}

	@Override
	public List<HRAgency> getAllHRAgency() {
		String sql = "SELECT [country], [agencyID], [agencyName], [phoneNumber], "
				+ "[address], [effectiveDate], [expirationDate]" + "FROM [dbo].[humanResourceAgency]";
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			List<HRAgency> hrAgencyDataList = new ArrayList<>();
			while (resultSet.next()) {
				HRAgency hrAgency = new HRAgency();
				hrAgency.setCountry(resultSet.getString(1));
				hrAgency.setAgencyId(resultSet.getString(2));
				hrAgency.setAgencyName(resultSet.getString(3));
				hrAgency.setPhoneNumber(resultSet.getString(4));
				hrAgency.setAddress(resultSet.getString(5));
				hrAgency.setEffectiveDate(resultSet.getString(6));
				hrAgency.setExpirationDate(resultSet.getString(7));
				hrAgencyDataList.add(hrAgency);

			}
			return hrAgencyDataList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<HRAgency> getHRAgencyStillEffective() {
		String sql = "SELECT [country], [agencyID], [agencyName], [phoneNumber],"
				+ "[address], [effectiveDate], [expirationDate]" + "FROM [dbo].[humanResourceAgency]"
				+ "WHERE [expirationDate] > convert(date, GETDATE())";
		ConnectionUtil connectionUtil = new ConnectionUtil();
		List<HRAgency> hrAgencyDataList = new ArrayList<>();
		try (Connection connection = connectionUtil.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				HRAgency hrAgency = new HRAgency();
				hrAgency.setCountry(resultSet.getString(1));
				hrAgency.setAgencyId(resultSet.getString(2));
				hrAgency.setAgencyName(resultSet.getString(3));
				hrAgency.setPhoneNumber(resultSet.getString(4));
				hrAgency.setAddress(resultSet.getString(5));
				hrAgency.setEffectiveDate(resultSet.getString(6));
				hrAgency.setExpirationDate(resultSet.getString(7));
				hrAgencyDataList.add(hrAgency);
			}
			return hrAgencyDataList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public HRAgency getHRAgencyByPrimaryKey(String country, String agencyID) {
		String sql = "SELECT [country], [agencyID], [agencyName], [phoneNumber], "
				+ "[address], [effectiveDate], [expirationDate]" + "FROM [dbo].[humanResourceAgency]"
				+ "WHERE country=? AND agencyID=?";
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, country);
			statement.setString(2, agencyID);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				HRAgency hrAgency = new HRAgency();
				hrAgency.setCountry(resultSet.getString(1));
				hrAgency.setAgencyId(resultSet.getString(2));
				hrAgency.setAgencyName(resultSet.getString(3));
				hrAgency.setPhoneNumber(resultSet.getString(4));
				hrAgency.setAddress(resultSet.getString(5));
				hrAgency.setEffectiveDate(resultSet.getString(6));
				hrAgency.setExpirationDate(resultSet.getString(7));
				return hrAgency;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<HRAgency> getHRAgencyByAddressPatternMatch(String location) {
		String sql = "SELECT [country], [agencyID], [agencyName], [phoneNumber],"
				+ "[address], [effectiveDate], [expirationDate]" + "FROM [dbo].[humanResourceAgency]"
				+ "WHERE [address] LIKE ?";
		ConnectionUtil connectionUtil = new ConnectionUtil();
		List<HRAgency> hrAgencyDataList = new ArrayList<>();
		try(Connection connection = connectionUtil.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, ("%"+location+"%"));
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				HRAgency hrAgency = new HRAgency();
				hrAgency.setCountry(resultSet.getString(1));
				hrAgency.setAgencyId(resultSet.getString(2));
				hrAgency.setAgencyName(resultSet.getString(3));
				hrAgency.setPhoneNumber(resultSet.getString(4));
				hrAgency.setAddress(resultSet.getString(5));
				hrAgency.setEffectiveDate(resultSet.getString(6));
				hrAgency.setExpirationDate(resultSet.getString(7));
				hrAgencyDataList.add(hrAgency);
			}
			return hrAgencyDataList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public boolean updateHRAgency(HRAgency hrAgency) {
		String sql = "UPDATE [dbo].[humanResourceAgency]" + "SET [agencyName]=?,"
				+ "[phoneNumber]=?, [address]=?, [effectiveDate]=(convert(Date,?,112)), [expirationDate]=(convert(Date,?,112))"
				//Parse string into date, 112 =ISO Date yyyymmdd.
				+ "WHERE [country]=? AND [agencyID]=? ";
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, hrAgency.getAgencyName());
			statement.setString(2, hrAgency.getPhoneNumber());
			statement.setString(3, hrAgency.getAddress());
			statement.setString(4, hrAgency.getEffectiveDate());
			statement.setString(5, hrAgency.getExpirationDate());
			statement.setString(6, hrAgency.getCountry());
			statement.setString(7, hrAgency.getAgencyId());
			int countOfUpdate = statement.executeUpdate();
			return countOfUpdate > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteHRAgency(String country, String agencyID) {
		String sql = "Delete FROM [dbo].[humanResourceAgency]" + "WHERE [country]=? AND [agencyID]=?";
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, country);
			statement.setString(2, agencyID);
			int countOfUpdate = statement.executeUpdate();
			return countOfUpdate > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}


}
