package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DemoLog4j {

	public static void main(String[] args) {
		// Log4j
		
		Logger log = LogManager.getLogger();
		log.info("This is information log");
		
	}
}
