import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CategoryTests {
    @Test
    public void testID1() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");

        WebElement weightField = driver.findElement(By.name("wg"));
        WebElement cmField = driver.findElement(By.name("ht"));
        WebElement bmiCategory = driver.findElement(By.name("desc"));
        WebElement calcButton = driver.findElement(By.name("cc"));

        weightField.sendKeys("45");
        cmField.sendKeys("170");
        calcButton.click();

        String category = bmiCategory.getAttribute("value");

        Assert.assertEquals(category, "Your category is Underweight");

        driver.quit();
    }

    @Test
    public void testID1_1() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");

        WebElement weightField = driver.findElement(By.name("wg"));
        WebElement cmField = driver.findElement(By.name("ht"));
        WebElement bmiCategory = driver.findElement(By.name("desc"));
        WebElement calcButton = driver.findElement(By.name("cc"));

        weightField.sendKeys("53");
        cmField.sendKeys("170");
        calcButton.click();

        String category = bmiCategory.getAttribute("value");

        Assert.assertEquals(category, "Your category is Underweight");

        driver.quit();
    }

    @Test
    public void testID2() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");

        WebElement weightField = driver.findElement(By.name("wg"));
        WebElement cmField = driver.findElement(By.name("ht"));
        WebElement bmiCategory = driver.findElement(By.name("desc"));
        WebElement calcButton = driver.findElement(By.name("cc"));

        weightField.sendKeys("70");
        cmField.sendKeys("180");
        calcButton.click();

        String category = bmiCategory.getAttribute("value");

        Assert.assertEquals(category, "Your category is Normal");

        driver.quit();
    }

    @Test
    public void testID2_1() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");

        WebElement weightField = driver.findElement(By.name("wg"));
        WebElement cmField = driver.findElement(By.name("ht"));
        WebElement bmiCategory = driver.findElement(By.name("desc"));
        WebElement calcButton = driver.findElement(By.name("cc"));

        weightField.sendKeys("70");
        cmField.sendKeys("180");
        calcButton.click();

        String category = bmiCategory.getAttribute("value");

        Assert.assertEquals(category, "Your category is Normal");

        driver.quit();
    }

    @Test
    public void testID3() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");

        WebElement weightField = driver.findElement(By.name("wg"));
        WebElement cmField = driver.findElement(By.name("ht"));
        WebElement bmiCategory = driver.findElement(By.name("desc"));
        WebElement calcButton = driver.findElement(By.name("cc"));

        weightField.sendKeys("82");
        cmField.sendKeys("180");
        calcButton.click();

        String category = bmiCategory.getAttribute("value");

        Assert.assertEquals(category, "Your category is Overweight");

        driver.quit();
    }

    @Test
    public void testID3_1() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");

        WebElement weightField = driver.findElement(By.name("wg"));
        WebElement cmField = driver.findElement(By.name("ht"));
        WebElement bmiCategory = driver.findElement(By.name("desc"));
        WebElement calcButton = driver.findElement(By.name("cc"));

        weightField.sendKeys("97");
        cmField.sendKeys("180");
        calcButton.click();

        String category = bmiCategory.getAttribute("value");

        Assert.assertEquals(category, "Your category is Overweight");

        driver.quit();
    }

    @Test
    public void testID4() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");

        WebElement weightField = driver.findElement(By.name("wg"));
        WebElement cmField = driver.findElement(By.name("ht"));
        WebElement bmiCategory = driver.findElement(By.name("desc"));
        WebElement calcButton = driver.findElement(By.name("cc"));

        weightField.sendKeys("77");
        cmField.sendKeys("160");
        calcButton.click();

        String category = bmiCategory.getAttribute("value");

        Assert.assertEquals(category, "Your category is Obese");

        driver.quit();
    }

    @Test
    public void testID4_1() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");

        WebElement weightField = driver.findElement(By.name("wg"));
        WebElement cmField = driver.findElement(By.name("ht"));
        WebElement bmiCategory = driver.findElement(By.name("desc"));
        WebElement calcButton = driver.findElement(By.name("cc"));

        weightField.sendKeys("90");
        cmField.sendKeys("160");
        calcButton.click();

        String category = bmiCategory.getAttribute("value");

        Assert.assertEquals(category, "Your category is Obese");

        driver.quit();
    }
}