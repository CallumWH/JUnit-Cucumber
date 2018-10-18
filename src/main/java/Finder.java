import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Finder
{	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong")
	WebElement greenTea;
	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231072\"]/div/p/span/span/strong")
	WebElement redTea;	
	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231735\"]/div/p/span/span/strong")
	WebElement oolongTea;
	
	public boolean FindMenuItems()
	{
		boolean allFound = true;
		
		if(greenTea.equals(null) || greenTea.equals(null) || greenTea.equals(null))
		{
			allFound = false;
		}
		
		
		return allFound;	}
}
