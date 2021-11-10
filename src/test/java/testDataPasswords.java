import org.testng.Assert;
import org.testng.annotations.Test;

public class testDataPasswords {
    @Test(dataProvider = "InputPassword",dataProviderClass = TestData.class)
    public void testPassword(String input){
      boolean validPassword = TestData.PasswordUtils.validatePassword(input);
      System.out.println(validPassword);
    }
    @Test(dataProvider = "InputUsername",dataProviderClass = TestData.class)
    public  void testUsername(String Username){
        boolean validUsername = TestData.PasswordUtils.validateUser(Username);
      System.out.println(validUsername);
    }

}
