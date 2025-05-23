package genericutility;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListernerUtility extends BaseClass implements ITestListener{
	
	

	@Override
	public void onTestStart(ITestResult result) {
		extReport.createTest(result.getName());
		test.log(Status.INFO, "Test execution started");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(screenshot);
		
		try {
			wUtil.getErrorScreenshot(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
