package application;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class userCheck {
	public static boolean usercheck(String userName , String Password) {
		int x = 1;
		//reads CSV file and outputs into ArrayList for use
		String file = "application\\user.csv";
		String line = "";
		String userinput = ("[" + userName + ",  " + Password + "]");
		List<List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			while((line = br.readLine()) != null) {
				String[] row = line.split(",");
				records.add(Arrays.asList(row));
			}
			br.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		// compares each line from CSV file to user input and returns boolean
		while (x < records.size()) {
			List recordstoString = records.get(x);
			String recordsString = recordstoString.toString();
			if (userinput.equals(recordsString) ) {
				return true;
			}
			x++;
		}
		return false;
	}

}