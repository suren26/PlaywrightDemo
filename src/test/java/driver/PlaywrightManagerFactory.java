package driver;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.*;

public class PlaywrightManagerFactory {
    static Playwright playwright;
    static Browser browser;
    static Page page;
    static BrowserContext context;
    String browserName;
    ChromePlaywright chromePlaywright;
    HeadlessPlaywright headlessPlaywright;

    @BeforeSuite
    public void setUp() {
        System.out.println("---Suite Set up---");
        browserName=System.getenv("BROWSER_NAME");
        if (browserName.equalsIgnoreCase("chrome")) {
            chromePlaywright=new ChromePlaywright();
            browser = chromePlaywright.getBrowser();
        } else if (browserName.equalsIgnoreCase("headless")) {
            headlessPlaywright= new HeadlessPlaywright();
            browser = headlessPlaywright.getBrowser();
        }
    }

    @BeforeTest
    public void testInitialisation() {
        System.out.println("---Test Set up---");
        context = browser.newContext();
        page = context.newPage();

    }

    @AfterTest
    public void testClosure() {
        System.out.println("---Test Tear Down---");
        context.close();
    }

    @AfterSuite
    public void tearDown() {
            System.out.println("---Suite Tear Down---");
            if (browserName.equalsIgnoreCase("chrome")) {
                chromePlaywright.closePlaywright();
            }
            else if (browserName.equalsIgnoreCase("headless")) {
                headlessPlaywright.closePlaywright();
            }
    }


    public Browser getBrowser() {
        return browser;
    }
    public Page getPage() {
        return page;
    }
    public BrowserContext getContext() {
        return context;
    }
}
