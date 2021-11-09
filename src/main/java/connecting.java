import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import sun.reflect.misc.FieldUtil;
import sun.rmi.rmic.iiop.Generator;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.security.PublicKey;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class connecting {

    public static AppiumDriverLocalService service;
    public static AndroidDriver<AndroidElement> driver;


      public AppiumDriverLocalService startSever(){
         boolean flag =  checkIfSeverIsRunning(4732);
         if (!flag) {
             service = AppiumDriverLocalService.buildDefaultService();
             service.start();
         }
          return service;
      }


      public static boolean checkIfSeverIsRunning(int port){
          boolean isSeverRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            isSeverRunning = true;

        } finally {
            serverSocket = null;
        }
        return isSeverRunning;
    }

    public static AndroidDriver<AndroidElement> capabilitities() throws IOException {
        // TODO Auto-generated method stub

        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/global.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        File appDir = new File("src/main");
        File app = new File(appDir, (String) properties.get("AppName"));
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, (String)properties.get("device"));
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

         driver = new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"),cap);
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }


    public static void getScreenshot(String s) throws IOException {
      File scrfile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"/Hasaki_testcase/ScreenshotAs/"+s+".png"));
    }

}


