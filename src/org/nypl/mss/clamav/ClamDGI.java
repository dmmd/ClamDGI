package org.nypl.mss.clamav;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class ClamDGI {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Logger logger = Logger.getLogger("org.nypl.mss.clamav.ClamScan");
        logger.setLevel(Level.OFF);
        BasicConfigurator.configure();
        
        InputStream fis = new FileInputStream(new File(args[0]));
        ClamScan c = new ClamScan("127.0.0.1", 3310, 600);
        ScanResult result = c.scan(fis);
                Pattern pattern = Pattern.compile("FOUND");
        Matcher matcher = pattern.matcher(result.getResult());
        
        if(matcher.find()){
            System.out.println("Virus-Found: Found");
            System.out.println("Virus-Signature: " + result.getSignature());
        }
        else{
            System.out.println("Virus-Found: Not Found");
        }
    }
}
