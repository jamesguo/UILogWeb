package ctrip.data.listener;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class InitListener implements ServletContextListener {
	
	private static Logger logger = Logger.getLogger(InitListener.class);
	
	public static Properties prop;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		logger.debug("init listener ... ..."+classLoader.getResource("ModelRealName.txt"));
		prop = new Properties();
		InputStream is = null;
		try {
			is = classLoader.getResourceAsStream("ModelRealName.txt");
			prop.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(is!=null)
				{
					is.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}
}
