package application;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

public class removeUser {
	public static void removeuser(int Id) throws IOException, CsvException {
	CSVReader reader2 = new CSVReader(new FileReader("application\\cars.csv"));
	List<String[]> allElements = reader2.readAll();
	allElements.remove(Id);
	FileWriter sw = new FileWriter("application\\cars.csv");
	CSVWriter writer = 
		    new CSVWriter(sw, ',', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER , CSVWriter.DEFAULT_LINE_END);
	writer.writeAll(allElements);
	writer.close();
	}
}
