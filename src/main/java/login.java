import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class login {
    public login(AndroidDriver<AndroidElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }
    @AndroidFindBy(id = "vn.hasaki.buyer:id/ivIconNavDrawer")
    public WebElement appbar;
    @AndroidFindBy(id = "vn.hasaki.buyer:id/tvBtnLogin")
    public WebElement tvBtnLogin;
    @AndroidFindBy(id ="vn.hasaki.buyer:id/edtPhoneEmail")
    public WebElement edtPhoneEmail;
    @AndroidFindBy(id = "vn.hasaki.buyer:id/btnSignIn")
    public WebElement btnSignIn;
    @AndroidFindBy(id = "vn.hasaki.buyer:id/textinput_error")
    public WebElement textinput_error1;
    @AndroidFindBy(id = "vn.hasaki.buyer:id/edtPassword")
    public WebElement edtPassword;
    @AndroidFindBy(id = "vn.hasaki.buyer:id/textinput_error")
    public WebElement textinput_error2;
    @AndroidFindBy(xpath = "//android.widget.Toast[1]")
    public WebElement toast;
    @AndroidFindBy(id = "vn.hasaki.buyer:id/nvNavView")
    public WebElement nvNavView;


}
