package info.wifi;

public class AccessPoint 
{
	private Location location;
	private String bssid;
	private int signal;
	
	public AccessPoint(String bss, int sig, Location loc)
	{
		location = loc;

		bssid = bss;
		signal = sig;
	}
	
	public String getBssid()
    {
    	return bssid;
    }
    
    public int getSignal()
    {
    	return signal;
    }
    
    public Location getLocation()
    {
    	return location;
    }
    
    public void setLocation(Location loc)
    {
    	location = loc;
    }
    
    
}


