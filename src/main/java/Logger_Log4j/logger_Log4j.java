package Logger_Log4j;

import org.apache.logging.log4j.*;

public class logger_Log4j {
	
	public static void main(String[] args) {
		Logger log = LogManager.getLogger("logger_Log4j");
		System.out.println("This Is Logger Demo");
		log.info("For info only");
		log.debug("For Debug");
		log.error("For Error Message");
		log.warn("For Warning Message");
	}
}
