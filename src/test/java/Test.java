import org.example.Main;
import org.testng.Assert;

public class Test {

    @org.testng.annotations.Test
    public void checkSumm() {
        int a = 1;
        int b = 2;
        int c = 1 + 2;
        Assert.assertEquals(new Main().summ(a, b), c);
    }
}
