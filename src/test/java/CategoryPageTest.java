import Pages.CategoryPage;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoryPageTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("CategoryPageTest.class");

    @Test
    public void shouldShowTheSameBigAndSmallImages() {
        CategoryPage categoryPage = mainPage.navigateAndHoverWomenLabel()
                .navigateAndClickBlousesLabel();
        categoryPage.navigateAndHoverImage()
                .navigateAndClickQuickViewButton();
        assertTrue(categoryPage.isBigPictureTheSameThatMiniature(), "Error: Picture on miniature and Big picture are different");
    }
}
