//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class test extends BaseTest{
//    @Test
//    public void deletePlaylist() throws InterruptedException {
//        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']")) ;
//        provideEmail("iana.kocharian@testpro.io");
//        providePassword("CwqOPgQw");
//        loginButton.click();
//        Actions actions = new Actions(driver);
//
//        List<String> playlists = new ArrayList<>();
//        playlists.add("test1");
//        playlists.add("test2");
//        playlists.add("test3");
//        playlists.add("test4");
//        playlists.add("test5");
//        playlists.add("test6");
//        playlists.add("test7");
//        playlists.add("test8");
//        playlists.add("test9");
//        System.out.println(playlists.contains("test1"));
//        for (int i = playlists.size()-1; i >=0 ; i--) {
//            if (playlists.contains("test2")){
//                actions.contextClick(i).perform();
//            ;}
//
//        }
//
////        for (String x : playlists) {
////            if (playlists.contains("test1")) {
////                System.out.println("thi is 'test1'");
////                break;
////            }
////        }
//
//
//
//       // WebElement playList = driver.findElement(By.xpath("//a[contains(@href, '#!/playlist/')]"));
//        //Thread.sleep(3000);
////        Actions actions = new Actions(driver);
////        actions.contextClick(playList).perform();
//        //Thread.sleep(3000);
//        WebElement deleteSongButton = driver.findElement(By.xpath("//li[contains(@data-testid, 'playlist-context-menu-delete')]"));
//        clickToElement(deleteSongButton);
//        //Thread.sleep(3000);
//        WebElement submitDeleteButton = driver.findElement(By.cssSelector("nav button[class='ok']"));
//        clickToElement(submitDeleteButton);
//        WebElement successNotify = driver.findElement(By.cssSelector("div[class='success show']"));
//        Assert.assertTrue(successNotify.isDisplayed());
//        // Assert.assertFalse(playList.isDisplayed());
//
//
//        }
//
//    }