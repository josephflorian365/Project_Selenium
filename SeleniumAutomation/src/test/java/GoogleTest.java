import junit.framework.TestCase;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleTest extends TestCase {
    //Variables
    private WebDriver driver;
    private static final String TIPO_DRIVER = "webdriver.chrome.driver";
    private static final String PATH_DRIVER = "chromedriver.exe";
    private String URL = "https://www.google.com";

    @BeforeClass
    public static void stUpBeforeClass() {
        System.out.println("INICIO DE TESTS");
        System.setProperty(TIPO_DRIVER, PATH_DRIVER);
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test
    public void testSourch() {
        String textoEnviado = "TEST01";
        WebElement txtSourch = driver.findElement(By.name("q"));
        txtSourch.sendKeys(textoEnviado);
        txtSourch.submit();
        // ESPERE UN MOMENTO HASTA QUE GOOGLE RESPONDA
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //VALIDAR SI EL TITULO CONTIENE EL TEXTO ENVIADO
        String titulo = driver.getTitle();
        Assert.assertTrue("TITULO VALIDO", titulo.contains(textoEnviado));
    }

    @After
    public void testDown(){
        driver.quit();
    }

    @AfterClass
    public static void tearDownAfterClass(){
        System.out.println("FINALIZARON LOS TEST");
    }
}