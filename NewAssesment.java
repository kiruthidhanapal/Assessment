package skoolgo.pixelmindit;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewAssesment {
	public static void main(String[] args) throws InterruptedException, IOException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get(" https://skoolgo.pixelmindit.com:8000/#/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//a[text()= 'Sign Up']")).click();
	File source = driver.getScreenshotAs(OutputType.FILE);
	File destination = new File("./snapShort/signup.png");
	FileUtils.copyFile(source, destination);
	driver.findElement(By.id("fullName")).sendKeys("kiruthiga");
	driver.findElement(By.id("email")).sendKeys("keerthiga2591@gmail.com");
	//driver.findElement(By.xpath("//select[text()= 'Phone number country']")).click();
	
	//phone input country select
	
	driver.findElement(By.className("PhoneInputCountrySelect")).click();
	List<WebElement> countryselect = driver.findElements(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[2]/form/div/div[1]/div/div[5]/div/div/span/div/div/select/option"));
	for(WebElement select :  countryselect) {
		if(select.getText().equals("India")) {
			select.click();
		}
	}

	
	//mobile number sent
	driver.findElement(By.id("mobile")).sendKeys("9003916479");
	
	//passport number sent
	driver.findElement(By.id("personalId")).sendKeys("R7");
	//dob select
	
//driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[1]")).click();
	

//nationality
	//driver.findElement(By.id("nationality")).click();
List<WebElement> nationalityList = driver.findElements(By.xpath("//*[@id=\"nationality\"]/option"));
for(WebElement List :  nationalityList) {
	if(List.getText().equals("India")) {
		List.click();
	}
}



//gender select 
List<WebElement> optionList = driver.findElements(By.xpath("//*[@id=\"gender\"]/option"));
for(WebElement webElement : optionList) {
	if(webElement.getText().equals("Female")) {
		webElement.click();
	}
}

driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiInput-input']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//p[text()='4']")).click();

//upload photo
WebElement scroll = driver.findElement(By.xpath("(//label[text()='Upload Photo'])[2]"));

driver.executeScript("arguments[0].scrollIntoView();", scroll);
scroll.click();
driver.findElement(By.id("uploadPhoto")).sendKeys("C:\\Users\\KIRUTHIGA\\Desktop\\Pappu pic\\papp.jpg");


//password sent
driver.findElement(By.id("password")).sendKeys("kiruthiga251191");
driver.findElement(By.id("confirmPassword")).sendKeys("kiruthiga251191");
//check box selctv
WebElement box = driver.findElement(By.id("Accept"));
driver.executeScript("arguments[0].click();", box);


// click create account

driver.findElement(By.id("create-account")).click();
File source1 = driver.getScreenshotAs(OutputType.FILE);
File destination1 = new File("./snapShort/createAccount.png");
FileUtils.copyFile(source1, destination1);
//Authentication
File source2 = driver.getScreenshotAs(OutputType.FILE);
File destination2 = new File("./snapShort/Authentication.png");
FileUtils.copyFile(source2, destination2);
driver.findElement(By.xpath("//button[text()='VERIFY']")).click();
//Logout
//1.Take the the screenshot of the click on Logout
File source3 = driver.getScreenshotAs(OutputType.FILE);
File destination3 = new File("./snapShort/logout.png");
FileUtils.copyFile(source3, destination3);
driver.findElement(By.xpath("(//span[@class='iconv1 iconv1-arrow-down'])[1]")).click();
driver.findElement(By.xpath("//font[text()='sign out']")).click();
}
	}
