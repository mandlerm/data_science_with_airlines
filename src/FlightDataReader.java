import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class FlightDataReader {
	private HashMap<Integer, Flights >  flightMap;
	
	public FlightDataReader(String fileName) {
		
		File file = new File(fileName);
		flightMap = new HashMap<Integer, Flights>();
		
		
		try {
			Scanner s = new Scanner(file);
			s.nextLine();
			int rowNumber = 1;
			while (s.hasNextLine()) {
				Flights f = new Flights(s.nextLine());
				flightMap.put(rowNumber, f);
				rowNumber++;
			}
	
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public HashMap<Integer, Flights> getFlightMap() {
		return flightMap;
	}

}
