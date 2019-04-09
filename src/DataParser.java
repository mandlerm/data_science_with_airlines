import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataParser {
	private Integer dayOfMonth;
	private Integer dayOfWeek;
	private String uniqueCarrier;
	private String tailNum;
	private String origin;
	private String destination;
	private Integer depDelay;
	private Integer arrDelay;
	private Integer distance;
	
	public DataParser(String fileName) {
		File file = new File(fileName);
		try {
			Scanner s = new Scanner(file);
			while (s.hasNextLine()) {
				
			}
			System.out.println(s.nextLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
