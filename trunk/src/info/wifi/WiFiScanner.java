package info.wifi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class WiFiScanner 
{
	public static ArrayList<String> scan()
	{
		ArrayList<String> output = new ArrayList<String>();
		
		Process process = null;
		
		try
		{
			process = Runtime.getRuntime().exec("netsh wlan show networks mode=bssid");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		InputStream out = process.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(out));
		String line;
		
		try
		{
			while((line = br.readLine()) != null)
			{
				output.add(line);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return output;
	}
	
	public static ArrayList<AccessPoint> parseAccessPoint(ArrayList<String> ap)
	{
		ArrayList<AccessPoint> output = new ArrayList<AccessPoint>();
		ArrayList<String> bssid = new ArrayList<String>();
		ArrayList<String> signalString = new ArrayList<String>();
		ArrayList<Integer> signalInt = new ArrayList<Integer>();
		
		
		for(String str : ap)
		{
			if(str.indexOf("BSSID") == -1 && str.indexOf("Signal") == -1)
			{
				ap.remove(str);
			}
		}
		
		for(String str : ap)
		{
			if(str.indexOf("BSSID") != -1)
			{
				bssid.add(str.substring(str.indexOf(":") + 2));
			}
			else if(str.indexOf("Signal") != -1)
			{
				signalString.add(str.substring(str.indexOf(":") + 2));
			}
		}
		
		for(String str : signalString)
		{
			str = str.substring(0,str.indexOf("%"));
			signalInt.add(Integer.parseInt(str));
		}
		
		for(int i = 0; i < bssid.size(); i++)
		{
			output.add(new AccessPoint(bssid.get(i),signalInt.get(i),new Location(-1000,-1000)));
		}
		
		return output;
	}
}
