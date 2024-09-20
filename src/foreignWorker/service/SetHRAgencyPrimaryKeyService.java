package foreignWorker.service;

import javax.swing.JOptionPane;

public class SetHRAgencyPrimaryKeyService {
	
	public String[] setHRAgencyPrimaryKey() {
	String[] arr= new String[2];
	arr[0] = JOptionPane.showInputDialog("Please Enter County Name");
	arr[1]= JOptionPane.showInputDialog("Please Enter AgencyID");
	
	return arr;
	
	
	}
	
//	public static void main(String[] args) {
//		setHRAgencyPrimaryKeyService setAData = new setHRAgencyPrimaryKeyService();
//		String[] itisanarray = setAData.setHRAgencyPrimaryKey();
//		for (String i :itisanarray) {
//			System.out.println(i);
//		}
//		
//	}
	
}
