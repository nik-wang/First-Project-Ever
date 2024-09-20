package foreignWorker.dao;

import java.util.List;

import foreignWorker.bean.HRAgency;

public interface HRAgencyDAO {
	// Create
	boolean addHRAgency(HRAgency hrAgency);				//to insert small amount of data
	void saveHRAgnecy(List<HRAgency> hrAgencyDataList);		//to insert large amount of data
	
	// Read
	List<HRAgency> getAllHRAgency();
	List<HRAgency> getHRAgencyStillEffective();
	HRAgency getHRAgencyByPrimaryKey(String country, String agencyID);
	List<HRAgency> getHRAgencyByAddressPatternMatch(String location);
	
	// Update
	boolean updateHRAgency(HRAgency hrAgency);

	// Delete
	boolean deleteHRAgency(String country, String agencyID);

}
