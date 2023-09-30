import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @org.testng.annotations.DataProvider(name = "loginParameters")
    public static Object[][] provideCredentials() {
        return new Object[][]{
                {"demo@class.com", "te$t$tudent"},
                {"demo@class.com", "te$t$tudent"}
        };
    }

    @DataProvider(name = "incorrectCredentials")
    public static Object[][] provideIncorrectCredentials() {
        return new Object[][] {
                {"notExist@class.com", "te$t$tudent"},
                {"demo@class.com", "te$t$tudent"}
        };
    }
}
