package classes;

import java.io.IOException;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

public class AtomicTime {
	private String timeServer;
	/*
	 * Default Constructor. Initializes the time server.
	 */
	public AtomicTime(){
		timeServer = "nist1-nj.ustiming.org";
	}

	
	/*
	 * Gets the atomic time
	 * @return A string containing the atomic time or a string containing an error message.
	 */
	public String getAtomicTime(){
		//Prints out the time with an am or pm attached to it.
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss a");
        NTPUDPClient client = new NTPUDPClient();
        //Client times out after 8 seconds.
        client.setDefaultTimeout(8000);
        try {
            InetAddress hostAddr = InetAddress.getByName(timeServer);
            TimeInfo info = client.getTime(hostAddr);
            Date date = new Date(info.getReturnTime());
            client.close();
            return dateFormat.format(date);

        }catch (IOException e) {
        	client.close();
            return "Error: "+e;
        }
	}
}
