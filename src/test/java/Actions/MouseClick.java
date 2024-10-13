package Actions;

import com.microsoft.playwright.*;

import java.awt.*;

public class MouseClick {
    public static void main(String[] args) throws InterruptedException {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.setViewportSize(width,height);

        page.navigate("https://demoqa.com/buttons");

        // Generic click
        Locator clickMe = page.getByText("Click Me").nth(2);
        clickMe.click();

        // Double click
        Locator doubleClickMe = page.getByText("Double Click Me");
        doubleClickMe.dblclick();

        Thread.sleep(3000);

        // Hover over element
        page.getByText("Right Click Me").hover();


        playwright.close();

    }
}
