package Listeners_TestNg;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Custom_Listeners implements ITestListener {

	//This belongs to ITlistener and will execute before starting of test set/batch
	public void onStart(ITestContext arg) {
		System.out.println("Start Test execution"+arg.getName());
	}
	
	//This belongs to ITlistener and will execute after starting of test set/batch
	public void onFinsih(ITestContext arg) {
		System.out.println("finish Test execution"+arg.getName());
	}
	
	public void onTestStart(ITestContext arg0) {
		System.out.println("finish Test execution"+arg0.getName());
	}
	
	public void onTestSkipped(ITestContext arg0) {
		System.out.println("finish Test execution"+arg0.getName());
	}
	
	public void onTestSuccess(ITestContext arg0) {
		System.out.println("finish Test execution"+arg0.getName());
	}
	
	public void onTestF(ITestContext arg0) {
		System.out.println("finish Test execution"+arg0.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
}
