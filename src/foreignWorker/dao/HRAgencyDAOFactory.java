package foreignWorker.dao;

public class HRAgencyDAOFactory {
	public static HRAgencyDAO getHRAgencyDAO() {
		return new HRAgencyDAOImplement();
	}
}
