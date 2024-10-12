import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.awt.*;

public class Locators {

    public static void main(String[] args) throws InterruptedException {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.setViewportSize(width,height);

        page.navigate("https://getir.com/");
        System.out.println("title: " + page.title());

        // getByText
        Locator loginText = page.getByText("Giriş yap veya kayıt ol");
        System.out.println("1.text: " + loginText.innerText());

        // locate in shadow DOM
        Locator shadowDom = page.locator("div", new Page.LocatorOptions().setHasText("Giriş yap veya kayıt ol")).last();
        System.out.println("shadowDom: " + shadowDom.innerText());

        // getByRole
        Locator phoneNumber = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Telefon Numarası"));
        System.out.println("phone number: " + phoneNumber.innerText());
        phoneNumber.click();
        phoneNumber.fill("539-711");

        Thread.sleep(3000);

        // getByPlaceholder
        Locator phoneNumber2 = page.getByPlaceholder("Telefon Numarası");
        System.out.println("phone number2: " + phoneNumber2.innerText());

        // getByLabel
        Locator phoneContinueButton = page.getByLabel("login button");
        System.out.println("4.phoneContinueButton: " + phoneContinueButton.innerText());

        // loginButton
        Locator loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Giriş Yap"));
        loginButton.click();

        // test id
        Locator loginPhoneNumber = page.getByTestId("modal").getByPlaceholder("Telefon Numarası");
        System.out.println("5. login phone number: " + loginPhoneNumber.innerText());
        loginPhoneNumber.click();
        loginPhoneNumber.fill("0886");

        Locator cancelButton = page.getByTestId("modal").getByTestId("button").first();
        cancelButton.click();

        // getByAltText
        Locator beverage = page.getByAltText("Su & İçecek");

        // getByTest and filter options
        Locator beverage2 = page.getByTestId("text").filter(new Locator.FilterOptions().setHasText("Su & İçecek"));
        System.out.println("beverage2: " + beverage2.innerText());

        page.close();
        browser.close();
        playwright.close();
    }
}
