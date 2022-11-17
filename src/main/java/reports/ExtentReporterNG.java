package reports;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.xml.XmlSuite;
import com.aventstack.extentreports.ExtentReports;

public class ExtentReporterNG implements IReporter {
	private ExtentReports extent;

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,String outputDirectory) {
		extent = new ExtentReports();

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (Iterator<ISuiteResult> iterator = result.values().iterator(); iterator.hasNext();) {
			}
		}
		extent.flush();
		//extent.close();
	}

	/*private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				//test = extent.startTest(result.getMethod().getMethodName());

				//test.setStartedTime(getTime(result.getStartMillis()));
				//test.setEndedTime(getTime(result.getEndMillis()));

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				if (result.getThrowable() != null) {
					test.log(status, result.getThrowable());
				} else {
					test.log(status, "Test " + status.toString().toLowerCase()
							+ "ed");
				}

				//extent.endTest(test);
			}
		}
	}*/
}
