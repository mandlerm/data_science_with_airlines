import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class AirportDataReader {

	private HashMap<Integer, Airport> airportMap;
	
	public HashMap<Integer, Airport> getAirportMap() {
		return airportMap;
	}


	public AirportDataReader(String fileName) {
		File f = new File(fileName);
		airportMap = new HashMap<Integer, Airport>();
		
		try {
			Scanner s = new Scanner(f);
			s.nextLine();
			while (s.hasNextLine()) {
				String[] l = s.nextLine().split(",");
				int depAir = Integer.parseInt(l[5]);
				int arrAir = Integer.parseInt(l[8]);
				
				if (!airportMap.containsKey(depAir)) {
					Airport d = new Airport(depAir, 0, 1);
					airportMap.put(depAir,d);
				} else {
					int d = airportMap.get(depAir).getNumDepartures();
					airportMap.get(depAir).setNumDepartures(d + 1);
				}
				
				if (!airportMap.containsKey(arrAir)) {
					Airport a = new Airport(arrAir, 1, 0);
					airportMap.put(arrAir,a);
				} else {
					int a = airportMap.get(arrAir).getNumArrivals();
					airportMap.get(arrAir).setNumArrivals(a + 1);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
