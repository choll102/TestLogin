import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BuyVouchersTest extends connecting {
    @Test
    public void BuyVouchersTest() throws IOException, InterruptedException {
        service = startSever();
        AndroidDriver<AndroidElement> driver = capabilitities();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        Home h = new Home(driver);
        danhmuc f = new danhmuc(driver);
        PhieuMuaHang p = new PhieuMuaHang(driver);
        h.danhmuc.click();
        f.phieumuahang.click();
        Thread.sleep(3000);
         service.stop();


    }


}
