import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Home {
public Home(AndroidDriver<AndroidElement> driver){
          PageFactory.initElements(new AppiumFieldDecorator(driver),this);
}
// driver.findElementByXPath("//android.widget.TextView[@text='Danh mục']").click();
@AndroidFindBy(xpath="//android.widget.TextView[@text='Danh mục']")
public WebElement danhmuc;

}
