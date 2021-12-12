package application;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//adds attributes of a car to list to be read into an array later
public class addCar {
	public static void main(String colors, String makes, String models, String years, String mileages) throws IOException {
		String file = "application\\cars.csv";
		File dir = new File(file);
		String loc = dir.getCanonicalPath() + File.separator;
		FileWriter fstream = new FileWriter(loc, true);
		BufferedWriter out = new BufferedWriter(fstream);
		int length = lengthOf.getLength();
		String lengths = String.valueOf(length);
		
		out.write(lengths);
		out.write(", ");
		out.write(makes);
		out.write(", ");
		out.write(models);
		out.write(", ");
		out.write(years);
		out.write(", ");
		out.write(mileages);
		out.write(", ");
		out.write(colors);
		out.newLine();
		out.close();
	}
}