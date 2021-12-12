package application;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class addUser {
	public static void main(String userName, String Password) throws IOException {
		String file = "application\\user.csv";
		File dir = new File(file);
		String loc = dir.getCanonicalPath() + File.separator;
 
		FileWriter fstream = new FileWriter(loc, true);
		BufferedWriter out = new BufferedWriter(fstream);
 
		out.write(userName);
		out.write(", ");
		out.write(Password);
		out.newLine();
 
		//close buffer writer
		out.close();
	}
}

