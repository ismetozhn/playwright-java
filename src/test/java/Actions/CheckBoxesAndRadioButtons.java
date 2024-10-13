package Actions;

import com.microsoft.playwright.*;

import java.awt.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckBoxesAndRadioButtons {

    public static void main(String[] args) throws InterruptedException {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.setViewportSize(width,height);

        page.navigate("https://www.ebay.com/");

        Locator registerButton = page.getByText("register").first();
        registerButton.click();

        // Checkboxes and radio buttons
        Locator businessAccount = page.getByText("Business").first();
        businessAccount.check();
        assertThat(businessAccount).isChecked();
        Thread.sleep(3000);

        //businessAccount.setChecked(true);

        playwright.close();
    }
}
