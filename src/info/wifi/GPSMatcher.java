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
	for (AccessPoint a: currentAP)
	{
		for (AccessPoint b: masterAP)
		{
			if (a.getBssid().equals(b.getBssid()))
			{
				a.setLocation(b.getLocation());
			}
		}
	}
}

public void removeNullLocations()
{
	fillInLocations();
	for (int i = currentAP.size()-1; i >=0; i--)
	{
		if (currentAP.get(i).getBssid()==null)
		{
			currentAP.remove(i);
		}
	}
}
public Location determineLocation()
{
	removeNullLocations();
	ArrayList<AccessPoint> triPts = new ArrayList<AccessPoint>();
	for (int i = 0; i < 3; i++)
	{
		triPts.add(currentAP.get(i));
	}
}
	
}
