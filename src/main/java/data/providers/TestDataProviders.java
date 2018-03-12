package data.providers;

import org.testng.annotations.DataProvider;

public class TestDataProviders {

	@DataProvider(name = "Admin")

	public static Object[][] getDataAdmin() {

		return utils.TestDataFileReader.fillArrayWithDataFromFile(LinksToDataFiles.txtAdmin);

	}
	
	@DataProvider(name = "Doctor")

	public static Object[][] getDataDoctor() {

		return utils.TestDataFileReader.fillArrayWithDataFromFile(LinksToDataFiles.txtDoctor);

	}

	@DataProvider(name = "Patient")

	public static Object[][] getDataPatient() {

		return utils.TestDataFileReader.fillArrayWithDataFromFile(LinksToDataFiles.txtPatient);

	}
	
	@DataProvider(name = "Pharmacist")

	public static Object[][] getDataPharmacist() {

		return utils.TestDataFileReader.fillArrayWithDataFromFile(LinksToDataFiles.txtPharmacist);

	}
	
	@DataProvider(name = "MedicalRecord")

	public static Object[][] getDataMedicalRecord() {

		return utils.TestDataFileReader.fillArrayWithDataFromFile(LinksToDataFiles.txtMedicalRecord);

	}
	
	@DataProvider(name = "Prescription")

	public static Object[][] getDataPrescription() {

		return utils.TestDataFileReader.fillArrayWithDataFromFile(LinksToDataFiles.txtPrescription);

	}
	
	@DataProvider(name = "ChangePassword")

	public static Object[][] getChangePassword() {

		return utils.TestDataFileReader.fillArrayWithDataFromFile(LinksToDataFiles.txtChangePassword);

	}
	
}
