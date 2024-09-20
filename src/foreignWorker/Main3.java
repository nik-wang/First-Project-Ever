package foreignWorker;

import java.util.List;

import foreignWorker.bean.HRAgency;
import foreignWorker.dao.HRAgencyDAO;
import foreignWorker.dao.HRAgencyDAOImplement;
import foreignWorker.service.SetHRAgencyLocationService;

public class Main3 {

	public static void main(String[] args) {

		HRAgencyDAO hrAgencyDAO = new HRAgencyDAOImplement();
		SetHRAgencyLocationService setPrimaryKey = new SetHRAgencyLocationService();
		String location = setPrimaryKey.setHRAgencyLocation();
		
		List<HRAgency> hrAgencyDataList = hrAgencyDAO.getHRAgencyByAddressPatternMatch(location);
		for (HRAgency hrAgency: hrAgencyDataList) {
			System.out.println(hrAgency);
		}
		
		
		

//		HRAgencyDAO hrAgencyDAO = new HRAgencyDAOImplement();
//		SetHRAgencyPrimaryKeyService setPrimaryKey = new SetHRAgencyPrimaryKeyService();
//		String[] PrimaryKey = setPrimaryKey.setHRAgencyPrimaryKey();
//		String country = PrimaryKey[0];
//		String agencyID = PrimaryKey[1];
//
//		HRAgency hrAgency = hrAgencyDAO.getHRAgencyByPrimaryKey(country, agencyID);
//		System.out.println(hrAgency);
//
	}

}
