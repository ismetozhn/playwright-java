package iFrame;

import com.microsoft.playwright.*;

import java.awt.*;

public class IFrameLocator {
    public static void main(String[] args) throws InterruptedException {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.setViewportSize(width,height);

        page.navigate("https://the-internet.herokuapp.com/iframe");

        Locator title = page.locator("//h3");
        System.out.println("title: " + title.innerText());

        // Frame Locator
        FrameLocator frameLocator = page.frameLocator("#mce_0_ifr");

        Locator body = frameLocator.getByText("Your content goes here.");
        body.click();
        body.clear();

        Locator inputText = frameLocator.getByLabel("Rich Text Area. Press ALT-0 for help.");
        inputText.fill("ismetozhn");

        Thread.sleep(3000);

        Locator elementalSeleniumText = page.getByText("Elemental Selenium");
        System.out.println("text: " + elementalSeleniumText.innerText());

        page.close();
        browser.close();
        playwright.close();

    }
}
