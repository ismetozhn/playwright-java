package Actions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;

import java.awt.*;

public class DropdownMenu {

    public static void main(String[] args) throws InterruptedException {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.setViewportSize(width,height);

        page.navigate("https://www.ebay.com/");

        // Select options
        Locator selectCategory = page.getByLabel("Select a category for search");
        Thread.sleep(3000);

        // Select by value
        selectCategory.selectOption("2984"); //baby
        Thread.sleep(3000);

        // Select by label
        selectCategory.selectOption(new SelectOption().setLabel("Crafts"));
        Thread.sleep(3000);

        Locator searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        searchButton.click();
        Thread.sleep(3000);



        playwright.close();


    }
}
