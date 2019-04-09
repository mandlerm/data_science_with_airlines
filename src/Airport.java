
public class Airport {
	Integer airportID;
	Integer numArrivals;
	Integer numDepartures;
	
	public Airport(int id, int arr, int dep) {
		//index 5
		airportID = id;
		
		// index8 
		numArrivals = arr;
		
		// index5 == increment counter
		numDepartures = dep;
	}

	public void setNumArrivals(Integer numArrivals) {
		this.numArrivals = numArrivals;
	}

	public void setNumDepartures(Integer numDepartures) {
		this.numDepartures = numDepartures;
	}

	public Integer getAirportID() {
		return airportID;
	}

	public Integer getNumArrivals() {
		return numArrivals;
	}

	public Integer getNumDepartures() {
		return numDepartures;
	}

}
