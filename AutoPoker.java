import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class AutoPoker {

	public static void main(String args[]) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://facebook.com/");
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("FACEBOOK_EMAIL");
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("FACEBOOK_PASSWORD");
		driver.findElement(By.id("loginbutton")).click();
		while(true) {
			driver.get("https://facebook.com/pokes");
			WebElement pokeDashboard = driver.findElement(By.className("pokesDashboard"));
			java.util.List<WebElement> pokers = pokeDashboard.findElements(By.className("objectListItem"));
			for(WebElement poker : pokers) {
				WebElement pokeLink = poker.findElement(By.linkText("Poke Back"));
				pokeLink.click();
			}
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}
