package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TestDataFileReader {

	public static Object[][] fillArrayWithDataFromFile(String fileName) {

		String thisLine;

		BufferedReader myInput = null;

		try {
			myInput = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		List<Object[]> lines = new ArrayList<Object[]>();

		try {
			while ((thisLine = myInput.readLine()) != null) {
				lines.add(thisLine.split(";"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
//		lines.remove(0);
		Object[][] array = new Object[lines.size()][0];

		try {
			myInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lines.toArray(array);
	}
	
	/*
	// KITAS METODAS DUOMENIMS
	private static List<String> getTestData(String fileName) throws IOException {
	    List<String> records = new ArrayList<String>();
        String record;

        BufferedReader file = new BufferedReader(new FileReader(fileName));

        while ((record = file.readLine()) != null) {
            records.add(record);
        }
        file.close();

        return records;
	}
	// KITAS METODAS DUOMENIMS END	
*/
}
