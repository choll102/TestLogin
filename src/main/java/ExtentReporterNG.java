import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.*;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;

import java.util.List;
import java.util.Map;

public class ExtentReporterNG implements IReporter {
    private ExtentReports extent;
    ExtentSparkReporter htmlReporter;

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,String outputDirectory){
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/report.html");
        extent  = new ExtentReports();

        extent.attachReporter(htmlReporter);
        for (ISuite suite : suites){
            Map<String , ISuiteResult> resultMap = suite.getResults();
            for (ISuiteResult r : resultMap.values()){
                ITestContext context = r.getTestContext();
                buildTestNodes(context.getPassedTests(), Status.PASS);
                buildTestNodes(context.getFailedTests(),Status.FAIL);
                buildTestNodes(context.getSkippedTests(),Status.SKIP);
            }
        }
        extent.flush();
    }

    private void buildTestNodes(IResultMap passedTests, Status pass) {
        ExtentTest test;
        if (passedTests.size() > 0){
            for (ITestResult result : passedTests.getAllResults()){
                test = extent.createTest(result.getMethod().getMethodName());
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);
                String message = "Test " + pass.toString().toLowerCase() + "ed";

                if (result.getThrowable() != null)
                    message = result.getThrowable().getMessage();
                test.log(pass,message);
            }
        }
    }

}
