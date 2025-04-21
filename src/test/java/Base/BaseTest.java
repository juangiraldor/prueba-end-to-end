package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    protected static SoftAssert softAssertl;
    protected static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void masterSetUp() {
        softAssertl = new SoftAssert();
        System.out.println("Inicializamos el WebDriver");
        Reporter.log("Inicializamos el WebDriver");
        System.setProperty("webdriver.chrome.driver", "C:/Users/juan_/OneDrive/Documentos/prueba-end-to-end/chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Maximizamos la pantalla");
        Reporter.log("Se maximiza la pantalla");
        driver.manage().window().maximize();
        Reporter.log("Ingresamos la URL");
        System.out.print("Ingresamos la URL:");
        driver.get("https://poliauth:8xONn1S6@uat-politecnico.us.seedcloud.co/poli-user-auth");
        System.out.println("Borramos cookies");
        driver.manage().deleteAllCookies();
    }

    @AfterMethod(alwaysRun = true)
    public void mastertearDown() {
        System.out.println("Finalizamos el Driver");
        Reporter.log("Finalizamos el Driver");
        driver.quit();
    }
}
