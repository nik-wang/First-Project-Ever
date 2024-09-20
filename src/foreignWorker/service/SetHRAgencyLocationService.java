package foreignWorker.service;

import javax.swing.JOptionPane;

public class SetHRAgencyLocationService {
	
	public String setHRAgencyLocation() {
		String location = JOptionPane.showInputDialog("Please enter a location");
		return location;
	}

}
