package org.nypl.mss.clamav;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.BasicConfigurator;

public class ClamDGI {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Logger logger = Logger.getLogger("org.nypl.mss.clamav.ClamScan");
        logger.setLevel(Level.OFF);
        BasicConfigurator.configure();
        
        InputStream fis = new FileInputStream(new File("/Users/dm/Desktop/workspace/eicar.com"));
        ClamScan c = new ClamScan("127.0.0.1", 3310, 600);
        ScanResult result = c.scan(fis);
        System.out.println("virus-scan: " + result.getResult());
    }
}
