import org.testng.annotations.DataProvider;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestData {
    @DataProvider(name ="InputPassword")
    public Object[][] getDataforPassword(){
        Object[][] objects = new Object[][]{
                {"12345"}, {"bsche123"},
                {"3284@8^&*"},{""}
        };
        return objects;
    }
    @DataProvider(name ="InputUsername")
    public Object[][] getDataforUsername(){
      Object[][] objects1 = new Object[][]{
              {"1233"},{"truongtrung102@gmail.com"},
              {"truongtrung"},{"nice"}
      } ;
      return objects1;
    }



    public static class PasswordUtils {
        private static final String VALID_PASSWORD_REGEX = "((?=.*\\d)(?=.*[a-z]).{6,32})";
        private static  final  String VALID_USERNAME_REGEX = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
public  static boolean validatePassword (String password){
    Pattern pattern = Pattern.compile(VALID_PASSWORD_REGEX);
    Matcher matcher = pattern.matcher(password);
    return matcher.matches();
}

    public static boolean  validateUser (String user){
        Pattern pattern = Pattern.compile(VALID_USERNAME_REGEX);
        Matcher matcher = pattern.matcher(user);
        return matcher.matches();
    }

    }
}
