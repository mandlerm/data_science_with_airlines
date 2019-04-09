import java.util.ArrayList;
import java.util.HashMap;

public class DataAnalysis {
	private FormattedOutput fo = new FormattedOutput();
	
	HashMap<Integer, String> answers = new HashMap<Integer, String>();

// question 1	
	public String highestCancelledFlights(HashMap<Integer, Flights> flights) {
		HashMap<String, int[]> airlines = new HashMap<String, int[]>();
		
		String air;
		Boolean delay;
		
		for(int row : flights.keySet()) {
			int[] info = new int[2];
			air  = flights.get(row).getUniqueCarrier();
			delay = flights.get(row).getCancelled();
	
			if (airlines.containsKey(air)) {
				info = airlines.get(air);
				info[0] = info[0] += 1 ;
				if (delay) {
					info[1] = info[1] += 1;
				}
			} else {
				info[0] = 1;
				if (delay)
					info[1] = 1;
				else 
					info[1] = 0;
			}
			airlines.put(air, info);
			
		}
		
		String winner = "";
		Double percentage = 0.0;
		
		for (String carrier : airlines.keySet()) {
			
			Integer numFlight = airlines.get(carrier)[0];
			Double cancels = (double)airlines.get(carrier)[1];
			Double percent = cancels / (numFlight);
			if (percent > percentage) {
				percentage = percent;
				winner = carrier;
			}
			
//		System.out.println(carrier + " " + numFlight + " " + cancels + "  "+ (cancels / numFlight));	
		}
		Double formattedPercent = percentage * 100;
		String formattedAnswer = winner + "," +  formattedPercent.toString() + "%";
//		System.out.println(formattedAnswer);
		fo.addAnswer(1, formattedAnswer);
		return formattedAnswer;
	}
	
	//question 2
	public String commonCancellation(HashMap<Integer, Flights> flights) {
		HashMap<String, Integer> can = new HashMap<String, Integer>();
		String cancelCode = null;
		for(Integer row : flights.keySet()) {
			String hasCode = flights.get(row).getCancelCode();
			if (!hasCode.isEmpty()) {
				 cancelCode = flights.get(row).getCancelCode();
				
				if(can.containsKey(cancelCode)) {
					Integer amt = can.get(cancelCode);
					Integer currentAmt = amt += 1;
					can.put(cancelCode, currentAmt);
				}
				else {
					can.put(cancelCode, 1);
				}
			}
		}
		
		int maxCan = 0;
		String maxCode = null;
		
		for(String c : can.keySet()) {
			int num = can.get(c); 
			if (num > maxCan) {
				maxCan = num;
				maxCode = c;
			}
		}
		fo.addAnswer(2, maxCode);
		return maxCode;
	}
	
	//question 3
	public String mostMiles(HashMap<Integer, Flights> flights) {
		HashMap<String, Integer> distanceMap = new HashMap<String, Integer>();
		Integer miles = 0;
		String tailNum = null;
		for(Integer row : flights.keySet()) {
			
			 tailNum = flights.get(row).getTailNum();
			 boolean cancel = flights.get(row).getCancelled();
			 
			 if(!tailNum.isEmpty() && !cancel) {
				 if(!distanceMap.containsKey(tailNum))
					 distanceMap.put(tailNum, 0);
				 
				if (flights.get(row).getDistance()!= null) {
					 miles = flights.get(row).getDistance();
					
					Integer m = distanceMap.get(tailNum);
					Integer currentAmt = m += miles;
					distanceMap.put(tailNum, currentAmt);
				}
			 }
		}
		
		Integer mostMiles = 0;
		String tailWinner = null;
		for(String tail : distanceMap.keySet()) {
			if(distanceMap.get(tail) > mostMiles) {
				mostMiles = distanceMap.get(tail);
				tailWinner = tail;
			}
		}
//		System.out.println(tailWinner +" " + mostMiles);
		if (tailWinner.isEmpty()) {
//			System.out.println(tailWinner + "<win miles>" + mostMiles);
		}
//		System.out.println(tailWinner + "<win miles>" + mostMiles);
		fo.addAnswer(3, tailWinner);
		return tailNum;
	}
	
	
//question 4
	public void busiestAirport(HashMap<Integer, Airport> airportMap) {
		int maxPort = 0;
		int maxCount = 0;
		
		for(int airport : airportMap.keySet()) {
			int total = airportMap.get(airport).numArrivals + airportMap.get(airport).numDepartures;
			if (total > maxCount) {
				maxCount = total;
				maxPort = airport;
			}
		}
		fo.addAnswer(4, maxPort);	
	}
	
	//question 5
	public void sourceAirport(HashMap<Integer, Airport> airportMap) {
		int maxPort = 0;
		int maxSource = 0;
		
		for(int airport : airportMap.keySet()) {
			int departures = airportMap.get(airport).numDepartures;
			int arrivals = airportMap.get(airport).numArrivals;
			int source = departures - arrivals;
			if (source > maxSource) {
				maxSource = source;
				maxPort = airport;
			}
		}
//		System.out.println(maxPort);
		fo.addAnswer(5, maxPort);
		
	}
	//question 6
	public void sinkAirport(HashMap<Integer, Airport> airportMap) {
		int maxPort = 0;
		int maxSink = 0;
		
		for(int airport : airportMap.keySet()) {
			int departures = airportMap.get(airport).numDepartures;
			int arrivals = airportMap.get(airport).numArrivals;
			int sink = arrivals - departures;
			if (sink > maxSink) {
				maxSink = sink;
				maxPort = airport;
			}
		}
//		System.out.println(maxPort);
		fo.addAnswer(6, maxPort);
		
	}
	
	//question 7
	public Integer aaDelay(HashMap<Integer, Flights> flights) {
		int count = 0;
		int arr = 0;
		int dep = 0;
		
		for(Integer row : flights.keySet()) {
			String tail = flights.get(row).getUniqueCarrier();
			Boolean diverted = flights.get(row).getDiverted();
			Boolean cancelled = flights.get(row).getCancelled();
		
			
			if ((tail.equals("AA") && !diverted && !cancelled)) {
				if (flights.get(row).getArrDelay() != null)
					arr = flights.get(row).getArrDelay();
				if (flights.get(row).getDepDelay() !=null) 
					 dep = flights.get(row).getDepDelay();
				
				if( (arr >= 60) || (dep >= 60))
					count++;
			}
		}
//		System.out.println(count);
		fo.addAnswer(7, count);
		return count;
	}
	
	//question 8
	public String delayMakeUp(HashMap<Integer, Flights> flights) {
		int largestDelay = 0;
		int day = 0;
		String tail = null;
		
		for(Integer row : flights.keySet()) {
			if(!flights.get(row).getCancelled()) {
				int amt = flights.get(row).getDelayCatchUp();
//				if(amt > 10) System.out.println(amt);
				if (amt > largestDelay) {
					largestDelay = amt;
					day = flights.get(row).getDayOfMonth();
					tail = flights.get(row).getTailNum();
				}
//				System.out.println(largestDelay);
			}
		}
		String d = Integer.toString(day);
		String l = Integer.toString(largestDelay);
		
		String answerFormat = d + "," + largestDelay + "," + tail;
//		System.out.println(answerFormat);
		fo.addAnswer(8, answerFormat);
		return null;
	}
	
	// most popular destination  #9
	public void mostPopularDestination(HashMap<Integer, Airport> airportMap) {
		int max = 0;
		int airportCode = 0;
		
		for(int air : airportMap.keySet()) {
			int airportArrivals = airportMap.get(air).getNumArrivals();
			if (airportArrivals > max) {
				max = airportArrivals;
				airportCode = air;
			}
			
		}
		String answer = "What airport is the most popular destination: " + Integer.toString(max) + " arrivals, for airport " + Integer.toString(airportCode);
		fo.addAnswer(9, answer);
	}
	
	public void printAnswers() {
		fo.writeAnswers();
	}
}
