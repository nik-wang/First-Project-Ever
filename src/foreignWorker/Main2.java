package foreignWorker;

import java.util.List;

import foreignWorker.bean.HRAgency;
import foreignWorker.dao.HRAgencyDAO;
import foreignWorker.dao.HRAgencyDAOImplement;

public class Main2 {

	public static void main(String[] args) {
		
		HRAgencyDAO hrAgencyDAO = new HRAgencyDAOImplement();
		HRAgency hrAgency = hrAgencyDAO.getHRAgencyByPrimaryKey("越南", "V-8");
		System.out.println(hrAgency);

		
		
		
		
		
		
		
		
		
		//Test Create 
//		HRAgency hragency = new HRAgency();
//		hragency.setCountry("Taiwan");
//		hragency.setAgencyId("A-1");
//		hragency.setAgencyName("iSpan");
//		hragency.setPhoneNumber("(07)9699-885 #6511");
//		hragency.setAddress("801, Kaohsiung City, Qianjin District, Zhongzheng 4th Rd, No. 211, Floor8-1");
//		hragency.setEffectiveDate("20240423");
//		hragency.setExpirationDate("20240918");
//		
//		HRAgencyDAO hrAgencyDAO = new HRAgencyDAOImplement();
//		hrAgencyDAO.addHRAgency(hragency);
		
		
		//Test Read

		//Test Read all
//		HRAgencyDAO hrAgencyDAO = new HRAgencyDAOImplement();
//		List<HRAgency> hrAgencyDataList = hrAgencyDAO.getAllHRAgency();
//		for (HRAgency hrAgency: hrAgencyDataList) {
//			System.out.println(hrAgency);
//		}
		
		//Test if still effective
//		HRAgencyDAO hrAgencyDAO = new HRAgencyDAOImplement();
//		List<HRAgency> agenciesStillEffective = hrAgencyDAO.getHRAgencyStillEffective();
//		for (HRAgency hrAgency: agenciesStillEffective)
//		System.out.println(hrAgency);
		
		//Test location pattern
//		System.out.println("start");
//		HRAgencyDAO hrAgencyDAO = new HRAgencyDAOImplement();
//		List<HRAgency> agenciesQuezon = hrAgencyDAO.getHRAgencyByAddressPatternMatch("quezon");
//		for (HRAgency hrAgency: agenciesQuezon)
//		System.out.println(hrAgency);
		
		//Test Update
//		HRAgency hragency= new HRAgency();
//		hragency.setCountry("Taiwan");
//		hragency.setAgencyId("A-1");
//		hragency.setAgencyName("iSpan Kaohsiung");
//		hragency.setEffectiveDate("20240423");
//		hragency.setExpirationDate("20240918");
//		HRAgencyDAO hrAgencyDAO = new HRAgencyDAOImplement();
//		boolean updateHRAgency = hrAgencyDAO.updateHRAgency(hragency);
//		System.out.println(updateHRAgency);
		
		//Test Delete
//		HRAgencyDAO hrAgencyDAO = new HRAgencyDAOImplement();
//		boolean deleteHRAgency = hrAgencyDAO.deleteHRAgency("Taiwan", "A-1");
//		System.out.println(deleteHRAgency);
		
	}
}
