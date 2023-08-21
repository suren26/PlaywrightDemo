package driver;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class ChromePlaywright extends BrowserManager {

    ChromePlaywright(){
        this.playwright = Playwright.create();
        this.browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }
    public static Browser getBrowser(){
        return browser;
    }
    public  static void closePlaywright(){ playwright.close();}
}