package generic_utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	WebDriver driver;
	Actions act;
	WebDriverWait wait;

	public WebDriverUtility(WebDriver driver) {
		this.driver = driver;
		this.act = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	// Open URL
	public void openUrl() {
		driver.get("http://localhost:8888/");
	}

	// Get page title
	public String getPageTitle() {
		return driver.getTitle();
	}

	// Get current URL
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	// Check if title equals expected
	public boolean isTitleEquals(String expectedTitle) {
		return driver.getTitle().equals(expectedTitle);
	}

	// Check if current URL contains expected part
	public boolean isUrlContains(String expectedUrlPart) {
		return driver.getCurrentUrl().contains(expectedUrlPart);
	}

	// Refresh the current page
	public void refreshPage() {
		driver.navigate().refresh();
	}

	// Navigate back
	public void navigateBack() {
		driver.navigate().back();
	}

	// Navigate forward
	public void navigateForward() {
		driver.navigate().forward();
	}

	// Maximize window
	public void winMax() {
		driver.manage().window().maximize();
	}

	// Fullscreen window
	public void fullscreenWindow() {
		driver.manage().window().fullscreen();
	}

	// Minimize window
	public void winMin() {
		driver.manage().window().minimize();
	}

	// Get window size (Dimension)
	public void size() {
		driver.manage().window().getSize();
	}

	// Get window position (Point)
	public void position() {
		driver.manage().window().getPosition();
	}

	// Set window size
	public void setSize(int width, int height) {
		Dimension dimension = new Dimension(width, height);
		driver.manage().window().setSize(dimension);
	}

	// Set window position
	public void setPosition(int x, int y) {
		Point point = new Point(x, y);
		driver.manage().window().setPosition(point);
	}

	// Wait Methods

	// Implicit wait for page load
	public void waitForPageLoad() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	// Wait for element to be visible
	public void waitForElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Wait for element to be clickable
	public void waitForElementClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Wait for element to be invisible
	public void waitForElementInvisible(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	// Wait for element presence by locator
	public void waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	// Wait for text present in element
	public void waitForTextPresentInElement(WebElement element, String text) {
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	// Wait for alert presence
	public void waitForAlertPresent() {
		wait.until(ExpectedConditions.alertIsPresent());
	}

	// Wait for frame availability and switch to it
	public void waitForFrameAndSwitchToIt(By locator) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	// Wait for specific number of windows
	public void waitForNumberOfWindows(int expectedNumber) {
		wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumber));
	}

	// Wait for URL to contain substring
	public void waitForUrlContains(String fraction) {
		wait.until(ExpectedConditions.urlContains(fraction));
	}

	// Wait for title to contain substring
	public void waitForTitleContains(String fraction) {
		wait.until(ExpectedConditions.titleContains(fraction));
	}

	// Select Dropdown Methods
	
	// Select option by index
	public void Select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	// Select option by value attribute
	public void Select(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	// Select option by visible text
	public void Select(String visibleText, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}

	// Check if dropdown supports multiple selections
	public boolean isMultipleDropdown(WebElement dropdown) {
		Select sel = new Select(dropdown);
		return sel.isMultiple();
	}

	// Deselect option by index
	public void deselectByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.deselectByIndex(index);
	}

	// Deselect option by value
	public void deselectByValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.deselectByValue(value);
	}

	// Deselect option by visible text
	public void deselectByVisibleText(WebElement element, String visibleText) {
		Select sel = new Select(element);
		sel.deselectByVisibleText(visibleText);
	}

	// Deselect all options
	public void deselectAll1(WebElement element) {
		Select sel = new Select(element);
		sel.deselectAll();
	}

	// Deselect all options if multiple select dropdown
	public void deselectAll(WebElement dropdown) {
		Select sel = new Select(dropdown);
		if (sel.isMultiple()) {
			sel.deselectAll();
		}
	}

	// Check if element present on page 
	public boolean isElementPresent(By locator) {
		return driver.findElements(locator).size() > 0;
	}

	// Check if specific text is present in page source
	public boolean isTextPresent(String text) {
		return driver.getPageSource().contains(text);
	}

	// Hover mouse over element
	public void hover(WebElement targetElement) {
		act.moveToElement(targetElement).build().perform();
	}

	// Click on element
	public void click(WebElement targetElement) {
		act.click(targetElement).build().perform();
	}

	// Right-click on element
	public void rightClick(WebElement targetElement) {
		act.contextClick(targetElement).build().perform();
	}

	// Click and hold element
	public void clickAndHold(WebElement targetElement) {
		act.clickAndHold(targetElement).perform();
	}

	// Double click on element
	public void doubleClick(WebElement targetElement) {
		act.doubleClick(targetElement).build().perform();
	}

	// Move to element (basic)
	public void moveToElement(WebElement targetElement) {
		act.moveToElement(targetElement).build().perform();
	}

	// Move to element with offset
	public void moveToElement(WebElement targetElement, int xOffset, int yOffset) {
		act.moveToElement(targetElement, xOffset, yOffset).build().perform();
	}

	// Drag and drop from source to target
	public void dragAndDrop(WebElement source, WebElement target) {
		act.dragAndDrop(source, target).build().perform();
	}

	// Drag and drop by x and y offset
	public void dragAndDropBy(WebElement source, int xOffset, int yOffset) {
		act.dragAndDropBy(source, xOffset, yOffset).build().perform();
	}

	// Send keys (to focused element)
	public void sendKeys(CharSequence keys) {
		act.sendKeys(keys).build().perform();
	}

	// Send keys to specific element
	public void sendKeys(WebElement targetElement, CharSequence keys) {
		act.sendKeys(targetElement, keys).build().perform();
	}

	// Key down press (no release)
	public void keyDown(Keys key) {
		act.keyDown(key).build().perform();
	}

	// Key up release
	public void keyUp(Keys key) {
		act.keyUp(key).build().perform();
	}

	// JavaScript Executor Methods
	
	// Scroll to element
	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Scroll by x and y pixels
	public void scrollBy(int x, int y) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0], arguments[1])", x, y);
	}

	// Scroll to bottom of page
	public void scrollToBottom() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	// Scroll to top of page
	public void scrollToTop() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
	}

	// Click element using JS
	public void jsClick(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	// Set value of element using JS
	public void jsSetValue(WebElement element, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", element, value);
	}

	// Get value of element using JS
	public String jsGetValue(WebElement element) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", element);
	}

	// Alert Handling Methods
	
	// Accept alert popup
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	// Dismiss alert popup
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	// Get alert text
	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	// Send text to alert prompt
	public void sendTextToAlert(String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	// Frame Handling Methods
	
	// Switch to frame by index
	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	// Switch to frame by ID or name
	public void switchToFrameByIdOrName(String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	// Switch to frame by WebElement
	public void switchToFrameByElement(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	// Switch back to main content
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	// Window Handling Methods

	// Switch window by partial title match
	public void switchToWindowByTitle(String partialTitle) {
		Set<String> handles = driver.getWindowHandles();
		for (String h : handles) {
			driver.switchTo().window(h);
			if (driver.getTitle().contains(partialTitle)) {
				break;
			}
		}
	}

	// Switch window by partial URL match
	public void switchToWindowByUrl(String partialUrl) {
		Set<String> handles = driver.getWindowHandles();
		for (String h : handles) {
			driver.switchTo().window(h);
			if (driver.getCurrentUrl().contains(partialUrl)) {
				break;
			}
		}
	}

	// Close all windows except parent window handle
	public void closeAllWindowsExcept(String parentHandle) {
		Set<String> handles = driver.getWindowHandles();
		for (String h : handles) {
			if (!h.equals(parentHandle)) {
				driver.switchTo().window(h);
				driver.close();
			}
		}
		driver.switchTo().window(parentHandle);
	}

	// Get current window handle
	public String getCurrentWindowHandle() {
		return driver.getWindowHandle();
	}

	// Get total number of open windows
	public int getNumberOfOpenWindows() {
		return driver.getWindowHandles().size();
	}

	// Switch to a new window (different from current)
	public void switchToNewWindow() {
		String currentWindow = getCurrentWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String h : handles) {
			if (!h.equals(currentWindow)) {
				driver.switchTo().window(h);
				break;
			}
		}
	}

	// Clear text from element
	public void clearText(WebElement element) {
		element.clear();
	}

	// Send text to element
	public void sendText(WebElement element, String text) {
		element.sendKeys(text);
	}

	// Clear and send text
	public void clearAndSendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	// Check checkbox if not already selected
	public void checkCheckbox(WebElement checkbox) {
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
	}

	// Uncheck checkbox if selected
	public void uncheckCheckbox(WebElement checkbox) {
		if (checkbox.isSelected()) {
			checkbox.click();
		}
	}

	// Check if checkbox is selected
	public boolean isCheckboxChecked(WebElement checkbox) {
		return checkbox.isSelected();
	}

	// Select radio button if not already selected
	public void selectRadioButton(WebElement radioButton) {
		if (!radioButton.isSelected()) {
			radioButton.click();
		}
	}

	// Check if radio button is selected
	public boolean isRadioButtonSelected(WebElement radioButton) {
		return radioButton.isSelected();
	}

	// Get element text
	public String getElementText(WebElement element) {
		return element.getText();
	}

	// Get element attribute value
	public String getElementAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	// Get element tag name
	public String getTagName(WebElement element) {
		return element.getTagName();
	}

	// Get element CSS property value
	public String getCssValue(WebElement element, String propertyName) {
		return element.getCssValue(propertyName);
	}

	// Get element size (Dimension)
	public Dimension getElementSize(WebElement element) {
		return element.getSize();
	}

	// Get element location (Point)
	public Point getElementLocation(WebElement element) {
		return element.getLocation();
	}

	// Get element rectangle (location + size)
	public org.openqa.selenium.Rectangle getElementRect(WebElement element) {
		return element.getRect();
	}

	// Check if element is enabled
	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	// Check if element is displayed
	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	// Keyboard Actions

	// Press Enter key on element
	public void pressEnter(WebElement element) {
		element.sendKeys(Keys.ENTER);
	}

	// Press Escape key on element
	public void pressEscape(WebElement element) {
		element.sendKeys(Keys.ESCAPE);
	}

	// Press Tab key on element
	public void pressTab(WebElement element) {
		element.sendKeys(Keys.TAB);
	}

	// Press Ctrl+A (select all) on element
	public void pressCtrlA(WebElement element) {
		element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	}

	// Press Ctrl+C (copy) on element
	public void pressCtrlC(WebElement element) {
		element.sendKeys(Keys.chord(Keys.CONTROL, "c"));
	}

	// Press Ctrl+V (paste) on element
	public void pressCtrlV(WebElement element) {
		element.sendKeys(Keys.chord(Keys.CONTROL, "v"));
	}

	// Key down on specific element
	public void keyDownOnElement(WebElement element, Keys key) {
		act.keyDown(element, key).build().perform();
	}

	// Key up on specific element
	public void keyUpOnElement(WebElement element, Keys key) {
		act.keyUp(element, key).build().perform();
	}

	// Arrow key presses on element
	public void pressArrowUp(WebElement element) {
		element.sendKeys(Keys.ARROW_UP);
	}

	public void pressArrowDown(WebElement element) {
		element.sendKeys(Keys.ARROW_DOWN);
	}

	public void pressArrowLeft(WebElement element) {
		element.sendKeys(Keys.ARROW_LEFT);
	}

	public void pressArrowRight(WebElement element) {
		element.sendKeys(Keys.ARROW_RIGHT);
	}

	// Cookie Handling

	// Add cookie
	public void addCookie(org.openqa.selenium.Cookie cookie) {
		driver.manage().addCookie(cookie);
	}

	// Get cookie by name
	public org.openqa.selenium.Cookie getCookieNamed(String name) {
		return driver.manage().getCookieNamed(name);
	}

	// Delete cookie by name
	public void deleteCookieNamed(String name) {
		driver.manage().deleteCookieNamed(name);
	}

	// Delete all cookies
	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	// Screenshot Methods
	
	// Take screenshot and save to file
	public void takeScreenshot(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(filename);
		FileHandler.copy(src, dest);
	}
	
	//screenshot of a webelement
		public void takeElementScreenshot(WebElement element, String filePath) throws IOException {
			File src = element.getScreenshotAs(OutputType.FILE);
			File dest = new File(filePath);
			FileHandler.copy(src, dest);
		}
		
		//Screenshot with timestamp
		public void takeScreenshotWithTimestamp(String baseName) throws IOException {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmmss_ddMMyyyy");
			LocalDateTime now = LocalDateTime.now();
			String timestamp = dtf.format(now);
			takeScreenshot(baseName + "_" + timestamp);
		}


	// Properties File Utilities
	
	// Load properties from file
	public Properties loadProperties(String filepath) throws IOException {
		FileInputStream fis = new FileInputStream(filepath);
		Properties prop = new Properties();
		prop.load(fis);
		fis.close();
		return prop;
	}

	// Get property value by key from properties file
	public String getPropertyValue(String filepath, String key) throws IOException {
		Properties prop = loadProperties(filepath);
		return prop.getProperty(key);
	}

	// Time & Date Utilities

	// Get current date and time in formatted string
	public String getFormattedDateTime(String pattern) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
		return now.format(dtf);
	}

}
