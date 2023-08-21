package driver;
import com.microsoft.playwright.*;
public abstract class BrowserManager {
    protected static Playwright playwright;
    protected static Browser browser;
    public  static Browser getBrowser(){ return browser;}
    public  static Playwright getPlaywright(){ return playwright;}
    public  static void closePlaywright(){ playwright.close();}

}