package foreignWorker.bean;

public class HRAgency {
	private String country;
	private String agencyId;
	private String agencyName;
	private String phoneNumber;
	private String address;
	private String effectiveDate;
	private String expirationDate;
	
	
	//empty constructor
	public HRAgency() {
		super();
	}

	@Override
	public String toString() {
		return "HRAgency [country=" + country + ", agencyId=" + agencyId + ", agencyName=" + agencyName
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + ", effectiveDate=" + effectiveDate
				+ ", expirationDate=" + expirationDate + "]";
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

}
