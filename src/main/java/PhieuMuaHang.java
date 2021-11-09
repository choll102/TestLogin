import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class PhieuMuaHang {
    AndroidDriver<AndroidElement> driver;
    public PhieuMuaHang(AndroidDriver<AndroidElement>driver){
        this.driver = driver;
    }

    public void scrollToText()
    {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Radio Group\"));");

    }
    public void scrollToBottom() {

        int  x = driver.manage().window().getSize().width / 2;
        System.out.println(x);
        int start_y = (int) (driver.manage().window().getSize().height * 0.80 );
        System.out.println(start_y);
        int end_y = (int) (driver.manage().window().getSize().height / 0.20);
        System.out.println(end_y);
        TouchAction dragNDrop = new TouchAction(driver)
                .press(PointOption.point(x,start_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .moveTo(PointOption.point(x, end_y))
                .release();
        dragNDrop.perform();
    }
    public void swiptToBottom()
    {
        Dimension dim = driver.manage().window().getSize();
        int height = dim.getHeight();
        int width = dim.getWidth();
        int x = width/2;
        int top_y = (int)(height*0.80);
        int bottom_y = (int)(height* 0.20);
        System.out.println("coordinates :" + x + "  "+ top_y + " "+ bottom_y);
        TouchAction ts = new TouchAction(driver);
        ts.longPress(PointOption.point(x,top_y)).moveTo(PointOption.point(x,bottom_y)).release().perform();
    }


}
