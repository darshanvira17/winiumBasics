package winiumBasics;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class WiniumCalculator {
	//Before running the program start the Winium.Desktop.Driver.exe
	public static void main(String[] args) {
		try{
			
		DesktopOptions options= new DesktopOptions();
		options.setApplicationPath("C:\\windows\\System32\\calc.exe"); //Path to the application you want to automate
		//Sometime it takes a bit of time to start up so the buffer time of 5s
		Thread.sleep(5000);
		
		//Connect to the Winium Driver - by default it starts on 9999
		//to start it on any other port, open cmd go to the directory having the WiniumDriver
		//and type Winium.Desktop.Driver.exe --port "port" e.g. Winium.Desktop.Driver.exe --port 4444
		WiniumDriver driver= new WiniumDriver(new URL("http://localhost:9999"), options);
		
		//Find the attributes of an application by ids/names by using software like UISpy.exe
		driver.findElement(By.name("7")).click();
		driver.findElement(By.id("93")).click();
		driver.findElement(By.name("9")).click();
		driver.findElement(By.name("3")).click();
		driver.findElement(By.name("Equals")).click();
		Thread.sleep(2000);
		//Get/Read the Name from an attribute of an Application
		String output = driver.findElement(By.id("150")).getAttribute("Name");
		System.out.println("The Result is: "+output);
		
		//To close the running application in this case, the Calculator
		driver.close();
		
		}
		catch(Exception e){
			//throws MalformedURLException, InterruptedException
			e.printStackTrace();
		}
	}
}
