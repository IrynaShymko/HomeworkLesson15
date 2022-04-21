package Pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CategoryPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger("CategoryPage.class");

    public CategoryPage(WebDriver driver) {
        super(driver);
        logger.info("########## CategoryPage is created");
    }

    @FindBy(xpath = "//img[@title='Blouse']")
    private WebElement blousesImage;

    @FindBy(xpath = "//a[@class='quick-view']")
    private WebElement quickViewButton;

    @FindBy(xpath = "//iframe")
    private WebElement iframeProductDetails;

    @FindBy(xpath = "//ul[@id='thumbs_list_frame']//img[@class='img-responsive']")
    private List<WebElement> miniatureIconsList;

    @FindBy(xpath = "//img[@id='bigpic']")
    private WebElement bigPicture;


    public CategoryPage navigateAndHoverImage() {
        scrollToElement(blousesImage);
        navigateAndHoverWebElement(blousesImage);
        logger.info("<<<<<<<<<< Navigate to Product Image");
        return this;
    }

    public CategoryPage navigateAndClickQuickViewButton() {
        navigateAndHoverWebElement(quickViewButton);
        logger.info("<<<<<<<<<< Navigate to Quick View Button");
        clickOnElement(quickViewButton);
        return this;
    }

    public Boolean isBigPictureTheSameThatMiniature() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeProductDetails));
        logger.info("<<<<<<<<<< switch to iframe");
        Boolean result = false;
        for (int i = 0; i < miniatureIconsList.size(); i++) {
            navigateAndHoverWebElement(miniatureIconsList.get(i));
            logger.info("<<<<<<<<<< Navigate to miniature element " + (i + 1));
            String srcMiniature = miniatureIconsList.get(i).getAttribute("src").substring(0, 39);
            logger.info("<<<<<<<<<< source Miniature of icon " + (i + 1) + " is " + srcMiniature);
            navigateAndHoverWebElement(bigPicture);
            logger.info("<<<<<<<<<< Navigate to big picture ");
            String srcBigPicture = bigPicture.getAttribute("src").substring(0, 39);
            logger.info("<<<<<<<<<< Source BigPicture in case " + (i + 1) + "  is " + srcBigPicture);
            if (srcMiniature.equals(srcBigPicture)) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }
}
