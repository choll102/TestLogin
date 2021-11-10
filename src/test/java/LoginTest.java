import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;
import java.net.MalformedURLException;

import java.util.concurrent.TimeUnit;

public class LoginTest extends connecting {
    @Test
    public void enterInvalidUsernameTest() throws IOException {
        service = startSever();
        AndroidDriver<AndroidElement>driver = capabilitities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        login l = new login(driver);
        l.appbar.click();
        l.tvBtnLogin.click();
        l.edtPhoneEmail.sendKeys("test123");
        Assert.assertEquals("Email/ Số điện thoại không hợp lệ",l.textinput_error1.getText());
        service.stop();
    }
    @Test(dataProvider = "InputPassword",dataProviderClass = TestData.class)
    public void enterInvalidPasswordTest(String inputPassword) throws IOException {
        service = startSever();
        AndroidDriver<AndroidElement> driver = capabilitities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        login l = new login(driver);
        l.appbar.click();
        l.tvBtnLogin.click();
        l.edtPassword.sendKeys(inputPassword);
        Assert.assertEquals("Mật khẩu phải từ 6 ký tự",l.textinput_error2.getText());
        service.stop();
    }
    @Test
    public void enterInvalidUsernameAndPassword() throws IOException {
        service = startSever();
        AndroidDriver<AndroidElement> driver = capabilitities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        login l = new login(driver);
        l.appbar.click();
        l.tvBtnLogin.click();
        l.edtPhoneEmail.sendKeys("truongtrung102.wok@gmail.com");
        l.edtPassword.sendKeys("1234567");
        l.btnSignIn.click();
        Assert.assertEquals("Tên đăng nhập không khớp !",l.toast.getText());
        service.stop();
    }
   @Test
    public void enterValidUsernameAndPassword() throws IOException {
       service = startSever();
        AndroidDriver<AndroidElement> driver = capabilitities();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       login l = new login(driver);
       l.appbar.click();
       l.tvBtnLogin.click();
       l.edtPhoneEmail.sendKeys("ttt456tt@gmail.com");
       l.edtPassword.sendKeys("123123Ta");
       l.btnSignIn.click();
       System.out.println(l.nvNavView.isDisplayed());
       Assert.assertEquals("Đăng nhập thành công",l.toast.getText());
       service.stop();
   }


}
