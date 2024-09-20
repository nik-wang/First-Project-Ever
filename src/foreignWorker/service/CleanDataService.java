package foreignWorker.service;

import java.util.ArrayList;
import java.util.List;

import foreignWorker.bean.HRAgency;

public class CleanDataService {

	public List<HRAgency> cleanHRAgencyData(List<String> dataList) {
		ArrayList<HRAgency> list = new ArrayList<HRAgency>();
		for (int i = 0; i < dataList.size(); i++) {
			// Regular Expression(RegEx) syntax
			String[] split = dataList.get(i).trim().split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1);
			HRAgency hrAgency = new HRAgency();
			hrAgency.setCountry(split[0]);
			hrAgency.setAgencyId(split[1]);
			hrAgency.setAgencyName(split[2]);
			hrAgency.setPhoneNumber(split[3]);
			// remove double quotes(") from data
			hrAgency.setAddress(split[4].replaceAll("\"", ""));
			hrAgency.setEffectiveDate(split[5]);
			hrAgency.setExpirationDate(split[6]);
			list.add(hrAgency);
		}
		return list;
	}

}
