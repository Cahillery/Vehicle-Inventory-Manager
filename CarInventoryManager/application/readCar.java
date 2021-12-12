package application;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class readCar {
	public static String[][] readlist() {
		int x = 0;
		//reads CSV file and outputs into ArrayList for use
		String file = "application\\cars.csv";
		String line;
		int length = 0;
		String[][] carArray = null;
		List<String[]> lines = new ArrayList<String[]>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			while ((line = br.readLine()) != null) {
			     lines.add(line.split(","));
			     length++;
			}

			// convert our list to a String array.
			String[][] array = new String[lines.size()][0];
			lines.toArray(array);
			br.close();
			carArray = array;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return carArray;
	}
}