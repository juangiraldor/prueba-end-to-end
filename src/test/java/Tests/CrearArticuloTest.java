package Tests;

import Base.BaseTest;
import Pages.ContenidoPage;
import org.testng.annotations.Test;

public class CrearArticuloTest extends BaseTest {
    @Test
    public void crearArticulo() {
        ContenidoPage.login();
        ContenidoPage.crearArticulo();
        ContenidoPage.validarCreacion();
    }
}
