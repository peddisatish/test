
package com.test;

import org.apache.log4j.*;

import java.util.Enumeration;


public class Log4jInfo  {

    public static void main(String[] args) throws  Exception {

		String packageLoggingToBeModified = args[0];
		String logLevelToBeModified=args[1];

            Logger log = LogManager.getLogger(packageLoggingToBeModified);

                if (packageLoggingToBeModified.equalsIgnoreCase(Log4jInfo.class.getName())) {
                    OUT.error("Changing the LOG logLevelToBeModified for packageLoggingToBeModified " + log.getName() + " is restricted.");
                } else {
                    if (log != null && (logLevelToBeModified != null && logLevelToBeModified.trim().length() > 0)) {
                        Level l = Level.toLevel(logLevelToBeModified);
                        log.setLevel(l);
                        
                        //resetting current class so no one overrides it
                        log = LogManager.getLogger(Log4jInfo.class);
        				log.setLevel(Level.ERROR);
            			System.out.println("Log Level for Log4jInfo ::" + log.getLevel());
            
                        System.out.println(" The User   has Changed the log logLevelToBeModified to " + log.getLevel().toString() + " for packageLoggingToBeModified " + log.getName());
                    } 
                }
        } 

      

        try {
            Enumeration emr = LogManager.getCurrentLoggers();
            while (emr.hasMoreElements()) {
                Logger log = (Logger) emr.nextElement();
                System.out.println("Level ->" + log.getLevel() + "Name ->" + log.getName());
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
}

