import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Assertions {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.setViewportSize(1920,1080);

        page.navigate("https://www.ebay.com/");

        // hasUrl
        assertThat(page).hasURL("https://www.ebay.com/");

        // hasTitle
        assertThat(page).hasTitle("Electronics, Cars, Fashion, Collectibles & More | eBay");

        // not
        assertThat(page).not().hasTitle("test");

        // Locator Assertions
        //containsText
        Locator signIn = page.getByText("Sign In").first();
        assertThat(signIn).containsText("Sign");

        // has Attribute
        Locator searchBox = page.getByPlaceholder("Search for anything");
        assertThat(searchBox).hasAttribute("type","text");

        // hasText
        Locator register = page.getByText("register").first();
        assertThat(register).hasText("register");

        // isEditable
        assertThat(searchBox).isEditable();
        System.out.println(searchBox.isEditable());

        // isEmpty
        assertThat(searchBox).isEmpty();

        // isVisible
        assertThat(searchBox).isVisible();


        page.close();
        browser.close();
        playwright.close();
    }
}
