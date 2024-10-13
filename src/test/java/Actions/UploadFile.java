package Actions;

import com.microsoft.playwright.*;

import java.awt.*;

public class UploadFile {
    public static void main(String[] args) {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.setViewportSize(width, height);

        page.navigate("https://the-internet.herokuapp.com/upload");

        // Select one file
        Locator gozatButton = page.locator("input[id='file-upload']");
        gozatButton.click();

        playwright.close();
    }
}
