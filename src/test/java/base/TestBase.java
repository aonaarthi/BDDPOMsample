package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase() 
	{  prop =new Properties();
	 String path = System.getProperty("user.dir")
			 + "//src//test//resources//configFiles//config.properties";
	 
	 FileInputStream fin;
	
	 try {
		fin =new FileInputStream(path);
		prop.load(fin);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
		
	}
	
	public static void initialize()
	{
		String strBrowser = prop.getProperty("browser");
		 if (strBrowser.equalsIgnoreCase("chrome"))
		  {
			  WebDriverManager.chromedriver().setup();
			  driver= new ChromeDriver();
			  
		  }
		  
		  else if (strBrowser.equalsIgnoreCase("edge"))
		  {

			  WebDriverManager.chromedriver().setup();
			  driver= new EdgeDriver();
		  }
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
			driver.manage().window().maximize();
		    driver.manage().deleteAllCookies();
		    driver.get(prop.getProperty("url"));
		}
	}
	
	
	


