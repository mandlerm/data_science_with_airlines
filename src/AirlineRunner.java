import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AirlineRunner {
	

	public static void main(String [] args) {
		//"flights_small.csv"
		FlightDataReader fdr = new FlightDataReader("flights.csv");
		AirportDataReader adr = new AirportDataReader("flights.csv");
		DataAnalysis da = new DataAnalysis();
		
		// quest 1
		da.highestCancelledFlights(fdr.getFlightMap());
		
		// question 2
		da.commonCancellation(fdr.getFlightMap());
		
		// question 3
		da.mostMiles(fdr.getFlightMap());
		

		// question 4
		da.busiestAirport(adr.getAirportMap());
		
		// question 5
		da.sourceAirport(adr.getAirportMap());
	
			
		// question 6
		da.sinkAirport(adr.getAirportMap());
		
		
		// question 7
		da.aaDelay(fdr.getFlightMap());
		
		// question 8
		da.delayMakeUp(fdr.getFlightMap());
		
		// my question # 9 
		da.mostPopularDestination(adr.getAirportMap());
		
		da.printAnswers();
	}

}
