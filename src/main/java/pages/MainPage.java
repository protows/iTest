package pages;


import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;





public class MainPage extends Page  {

	public MainPage(PageManager pages){
		super(pages);
	}
	public MainPage ensurePageLoaded(){
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated((By.cssSelector("html.no-js body.ng-scope div.full-height.ng-scope div.main.full-height div.view.ng-scope div.container.ng-scope div.row.ng-scope div.col-md-12 h1.ng-binding"))));
		return this;
	}
@FindBy(xpath = "//input")	
private WebElement searchField;

@FindBy(css = "h4")	
private WebElement servicesLink;

@FindBy(xpath = "//li[2]/a/h4")	
private WebElement documentsLink;

@FindBy(xpath = "//li[3]/a/h4")	
private WebElement statusLink;

@FindBy(xpath = "//li[4]/a/h4")	
private WebElement myLogLink;

@FindBy(xpath = "//li[5]/a/h4")	
private WebElement aboutPortalLink;

@FindBy(xpath = "//a[contains(@href, 'https://www.facebook.com/igov.org.ua')]")
private WebElement portalsNewsOnFacebookLink;

@FindBy(xpath = "//a[contains(@href, 'https://docs.google.com/forms/d/1zyLyRcsL0wnB_VQeondrULHsEUi1dIaUSLJVWsdzbDY/viewform')]")
private WebElement noSuchServicesLink;

@FindBy(xpath = "//a[contains(@href, 'https://docs.google.com/forms/d/1ueU6PQa-OSA2Tsisxx2RbRWRJ9rLsFlPBlHsr7W-4gE/viewform')]")
private WebElement errorOrABugOnThePortalLink;

@FindBy(xpath = "//a[contains(@href, 'https://github.com/e-government-ua/i/wiki/%D0%AF%D0%BA-%D0%BF%D0%BE%D1%87%D0%B0%D1%82%D0%B8-%D1%80%D0%BE%D0%B1%D0%BE%D1%82%D1%83')]")
private WebElement joinOnGitHubLink;

@FindBy(xpath = "//a[contains(@href, 'https://github.com/e-government-ua/iForum/issues')]")
private WebElement commentsAndOpportunitiesLink;

public MainPage typeInSearchField(String text){
	searchField.clear();
	searchField.sendKeys(text);
	return this;
}
public ServicesPage clickServicesLink(){
	servicesLink.click();
	return pages.servicesPage;
}
public DocumentsPage clickDocumentsLink(){
	documentsLink.click();
	return pages.documentsPage;
}
public StatusPage clickStatusLink(){
	statusLink.click();
	return pages.statusPage;
}
public MyLogPage clickMyLogLink(){
	myLogLink.click();
	return pages.myLogPage;
}
public AboutPortal clickAboutPortalLink(){
	aboutPortalLink.click();
	return pages.aboutPortalPage;
}
public void isPortalsNewsOnFacebookLinkDisplayed() {
	portalsNewsOnFacebookLink.isDisplayed();
}
public void isNoSuchServicesLinkDisplayed() {
	noSuchServicesLink.isDisplayed();
}
public void isErrorOrABugOnThePortalLinkDisplayed() {
	errorOrABugOnThePortalLink.isDisplayed();
}
public void isJoinOnGitHubLinkDisplayed() {
	joinOnGitHubLink.isDisplayed();
}
public void isCommentsAndOpportunitiesLinkDisplayed() {
	commentsAndOpportunitiesLink.isDisplayed();	
}



public boolean isFinded(String text,String locator) {
	wait.until(presenceOfElementLocated((By.cssSelector("html.no-js body.ng-scope div.full-height.ng-scope div.main.full-height div.view.ng-scope div.container.ng-scope div.row.ng-scope div.col-md-12 h1.ng-binding"))));
	assertEquals(text, driver.findElement(By.linkText(locator)).getText());
	return true;
	}
	
public boolean isNotFinded() {
	  try{
		   wait.until(presenceOfElementLocated(By.cssSelector("html.no-js")));
		  return true;
	  }
	  catch (TimeoutException to){	return false;}
	  }
public boolean isLoggedIn() {
	if(driver.findElement(By.cssSelector("span")).isDisplayed()){
 	   return true;
  }else{
    return false;	 
  }
}



 
}

