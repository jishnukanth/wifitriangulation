package info.wifi;

import java.util.ArrayList;


public class GPSMatcher 
{
	private ArrayList<AccessPoint> currentAP;
    private ArrayList<AccessPoint> masterAP;
    
	public GPSMatcher(ArrayList<AccessPoint> available, ArrayList<AccessPoint> masterList)
	{
		currentAP = available;
		masterAP = masterList;
	}

//takes an access point from available and tries to match it to master list
//it then fills in the location data from the master list into the current list
public void fillInLocations()
{
	
}

//
public Location determineLocation()
{
	
}
	
}
