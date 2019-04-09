
public class Flights {
	private Integer dayOfMonth;
	private Integer dayOfWeek;
	private String uniqueCarrier;
	private String tailNum;
	private Integer origin;
	private Integer destination;
	private Integer depDelay;
	private Integer arrDelay;
	private Boolean cancelled;
	private Boolean diverted;
	private String cancelCode;
	private Integer distance;
	private Integer delayCatchUp;
	
	public Flights(String flightRow) {
		String[] columnData = flightRow.split(",");
		try {
			String dom = columnData[0];
			dayOfMonth = Integer.parseInt(dom);
		}
		catch (NumberFormatException e) {
			dayOfMonth = null;
		}
		
		try {
			String doy = columnData[1];
		 	dayOfWeek = Integer.parseInt(doy);
		}
		catch (NumberFormatException e) {
			dayOfWeek = null;
		}
			uniqueCarrier = columnData[3];
			tailNum = columnData[4];
		try {
			String o = columnData[5];
			origin = Integer.parseInt(o);
		}
		catch (NumberFormatException e) {
			origin = null;
		}
		
		try{ 
			String dest = columnData[8];
			destination = Integer.parseInt(dest);
		}
		catch (NumberFormatException e) {
			destination = null;
		}
		
		try{
			String delay = columnData[12];
			 depDelay = Integer.parseInt(delay);
		}
		catch (NumberFormatException e) {
			depDelay = null;
		}
		try {
			String d2 = columnData[16];
			 arrDelay = Integer.parseInt(d2);
		}
		catch (NumberFormatException e) {
			arrDelay = null;
		}
		
		
		String cancel = columnData[17];
		
		if (cancel.contains("1"))
			cancelled = true;
		else 
			cancelled = false;

		cancelCode = columnData[18];
		
		
		String divert = columnData[19];
		if (divert.contains("1"))
			diverted = true;
		else 
			diverted = false;
		
		
		
		try {
			String dist = columnData[21];
			 distance = Integer.parseInt(dist);
		}
		catch (NumberFormatException e) {
			 distance = null;
		}
		
		delayCatchUp = overComeDelay(depDelay, arrDelay);
	}

	public Boolean getDiverted() {
		return diverted;
	}

	public Integer overComeDelay(Integer depDelay, Integer arrDelay) {
		Integer catchUp;
		
		if((depDelay!= null) && (arrDelay!=null)) {
			if (depDelay > 0 && arrDelay <= 0)
				//catchUp = (arrive - start);
				catchUp = (depDelay);
			else 
				catchUp = -1;
		}
		else 
			catchUp = -1;
		
		return catchUp;
	}
	
	
	public Integer getDayOfMonth() {
		return dayOfMonth;
	}

	public Integer getDayOfWeek() {
		return dayOfWeek;
	}

	public String getUniqueCarrier() {
		return uniqueCarrier;
	}

	public String getTailNum() {
		return tailNum;
	}

	public Integer getOrigin() {
		return origin;
	}

	public Integer getDestination() {
		return destination;
	}

	public Integer getDepDelay() {
		return depDelay;
	}

	public Integer getArrDelay() {
		return arrDelay;
	}
	
	public String getCancelCode() {
		return cancelCode;
	}

	public Integer getDistance() {
		return distance;
	}	
	
	public Boolean getCancelled() {
		return cancelled;
	}
	
	public Integer getDelayCatchUp() {
		return delayCatchUp;
	}
}
