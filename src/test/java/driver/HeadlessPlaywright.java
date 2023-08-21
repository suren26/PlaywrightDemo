package driver;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;

public class HeadlessPlaywright extends BrowserManager {
    HeadlessPlaywright(){
        playwright = Playwright.create();
        browser=playwright.chromium().launch();
    }
    public static Browser getBrowser(){
        return browser;
    }
    public  static void closePlaywright(){ playwright.close();}
}