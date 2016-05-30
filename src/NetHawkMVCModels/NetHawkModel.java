package NetHawkMVCModels;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by bill on 5/27/2016.
 */
public class NetHawkModel {
    public int foundDNSError = 0;

    public int testDNS() {
        try {
            InetAddress inetAddr = InetAddress.getByName("www.google.com");
            ++foundDNSError;
            System.out.println("www.google.com == " + inetAddr.getHostAddress());
            return(1);
        } catch (UnknownHostException e) {
            return(0);
        }
    }
}
