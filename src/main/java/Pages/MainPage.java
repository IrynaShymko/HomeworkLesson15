package Pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger("MainPage.class");

    public MainPage(WebDriver driver) {
        super(driver);
        logger.info("########## MainPage is created");
    }

    @FindBy(xpath = "//a[@title='Women']")
    private WebElement womanLabel;

    @FindBy(xpath = "//a[@title='Blouses']")
    private WebElement blousesLabel;

    public MainPage navigateAndHoverWomenLabel() {
        navigateAndHoverWebElement(womanLabel);
        logger.info("<<<<<<<<<< Navigate to Women Label");
        return this;
    }

    public CategoryPage navigateAndClickBlousesLabel() {
        navigateAndHoverWebElement(blousesLabel);
        logger.info("<<<<<<<<<< Navigate to Blouses Label");
        clickOnElement(blousesLabel);
        return new CategoryPage(driver);
    }
}
