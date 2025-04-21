package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class ContenidoPage extends BaseTest {
    //Datos
    static String user = "Pruebas publicidad 1";
    static String password = "publicidad1";
    static String articleTitle = "Artículo de Prueba Juan Esteban Giraldo 5";
    static String image = "C:/Users/juan_/OneDrive/Documentos/prueba-end-to-end/img-prueba.jpg";
    static String altText = "prueba";
    static String bodyText = "Este es un artículo para la prueba End-to-End para el rol Analista de Calidad";

    //Localizadores
    private static WebElement userInput = driver.findElement(By.xpath("//*[@id='edit-name']"));
    private static WebElement userPassword = driver.findElement(By.xpath("//*[@id='edit-pass']"));
    private static WebElement loginButton = driver.findElement(By.xpath("//*[@id='edit-submit']"));

    public static void login() {
        // Se valida que el elemento Usuario se encuentre presente
        Assert.assertTrue(userInput.isDisplayed(), "El input Nombre de usuario no se muestra correctamente.");
        // Se escribe el nombre de usuario en el input
        userInput.sendKeys(user);

        // Se valida que el elemento Password se encuentre presente
        Assert.assertTrue(userPassword.isDisplayed(), "El input contraseña no se muestra correctamente.");
        // Se escribe el nombre de usuario en el input
        userPassword.sendKeys(password);

        //System.out.println("Hacer el reCAPTCHA manualmente. Tienes 20 segundos...");
        waiter(20000);

        //Dar click en el botón Iniciar Sesión
        loginButton.click();

        System.out.println("Se inició sesión correctamente");
        Reporter.log("Se inició sesión correctamente");
    }

    public static void crearArticulo() {

        // Se hace hover en las opciones para crear un artículo
        waiter(2000);
        Actions action = new Actions(driver);
        WebElement contentButton = driver.findElement(By.xpath("//*[@id='toolbar-item-administration-tray']/nav/div[1]/ul/li[2]"));
        action.moveToElement(contentButton).perform();
        WebElement addContentButton = driver.findElement(By.xpath("//*[@id='toolbar-item-administration-tray']/nav/div[1]/ul/li[2]/ul/li"));
        action.moveToElement(addContentButton).perform();
        WebElement addArticleButton = driver.findElement(By.xpath("//*[@id='toolbar-item-administration-tray']/nav/div[1]/ul/li[2]/ul/li/ul/li[1]"));
        addArticleButton.click();

        //Agregar nombre al artículo
        WebElement titleInput = driver.findElement(By.xpath("//*[@id='edit-title-0-value']"));
        titleInput.sendKeys(articleTitle);

        //Seleccionar Layout
        WebElement layoutDropdown = driver.findElement(By.xpath("//*[@id='edit-layout-selection']"));
        Select dropdown = new Select(layoutDropdown);
        dropdown.selectByIndex(3);

        //Cargar imagen
        WebElement selectFile = driver.findElement(By.xpath("//*[@id='edit-field-image-0-upload']"));
        selectFile.sendKeys(image);

        //Esperar a que el campo de texto alternativo aparezca
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement alternativeText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@id, 'edit-field-image-0-alt')]")
        ));

        //Se escribe el texto alternativo
        alternativeText.sendKeys(altText);

        //Escribir cuerpo del artículo
        WebElement body = driver.findElement(By.xpath("//*[@id='edit-body-wrapper']/div/div[2]/div/div/div[2]/div"));
        body.sendKeys(bodyText);

        //Dar clic guardar
        WebElement save = driver.findElement(By.xpath("//*[@id='edit-submit']"));
        save.click();

    }

    public static void validarCreacion() {
        WebElement content = driver.findElement(By.xpath("//*[@id='toolbar-item-administration-tray']/nav/div[1]/ul/li[2]"));
        content.click();

        WebElement searchBar = driver.findElement(By.xpath("//*[@id='edit-title']"));
        searchBar.sendKeys(articleTitle);
        WebElement filterButton = driver.findElement(By.xpath("//*[@id='edit-submit-content']"));
        filterButton.click();
        WebElement article = driver.findElement(By.xpath("//*[text()='Artículo de Prueba Juan Esteban Giraldo 5']"));
        if (article.isDisplayed()) {
            System.out.println("El artículo se creó correctamente");
            Reporter.log("Se creó el artículo correctamente");
        };
    }

    public static void waiter(int pSeconds) {
        try {
            Thread.sleep(pSeconds);
        } catch (Exception e){
            System.out.println("Algo ocurrió");
        }
    }
}
