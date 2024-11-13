// CarValuationTest.java
package alltestcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import allpages.CarValuationPage;
import commonutility.ReadFileData;
import reportutility.HighLevelReport;

public class CarValuationTest extends HighLevelReport {
	private WebDriver driver;
	private List<String> registrationdetails;
	private List<String> expectedValuationsData;

	@BeforeClass
	public void setUp() throws IOException {
		createNode("Setup");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.webuyanycar.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		CarValuationPage valuationPage = new CarValuationPage(driver);
		valuationPage.acceptAllCookies();
		String path=System.getProperty("user.dir")+ File.separator + "files" + File.separator;
		registrationdetails = ReadFileData.extractVehicleRegistrationNumbers(path+"car_input.txt");
		expectedValuationsData = ReadFileData.readExpectedOutput(path+"car_output.txt");
	}

	@Test
	public void testCarValuations() {
		createNode("testCarValuations");
		CarValuationPage valuationPage = new CarValuationPage(driver);

		for (int i = 0; i < registrationdetails.size(); i++) {
			String regNumber = registrationdetails.get(i);
			String expectedValuation = expectedValuationsData.get(i+1);

			valuationPage.enterRegistrationNumber(regNumber);
			valuationPage.enterMileage("70000"); // Example mileage
			valuationPage.clickonSearch();
            String actualValuation=valuationPage.getValuationResult();
			valuationPage.validatesResults(actualValuation, expectedValuation, actualValuation.split(",")[0]);
			valuationPage.clickonBackButton();
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
