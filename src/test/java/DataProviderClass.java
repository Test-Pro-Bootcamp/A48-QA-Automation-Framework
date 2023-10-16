import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @org.testng.annotations.DataProvider(name = "loginParameters")
    public static Object[][] provedCredentials() {
        return new Object[][]{
                {"demo@class.com", "te$t$tudent"},
                {"notExist@class.com", "te$t$tudent"}
        };
        //  (dataProvider = "loginParameters") - передать в @Test
        // пример: @Test(dataProvider = "incorrectCredentials", dataProviderClass = DataProviderClass.class)
    }

    @DataProvider(name = "incorrectCredentials")
    public static Object[][] provideIncorrectCredentials() {
        return new Object[][]{
                {"notExist@class.com", "te$t$tudent"},
                {"demo@class.com", ""}
        };
    }

    ;
}
