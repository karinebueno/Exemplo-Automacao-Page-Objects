import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.Normalizer;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestaPaginas {

    private WebDriver driver;

    private static final String baseUrl = "https://automacao.testerglobal.com/";

    Home homePage;


@Test
@DisplayName("Quando pesquisar produto por nome, então deve ser mostrado pagina do produto")
public void pesquisaProdutoPorNome() {

    //Entrar no site de teste
    driver.get(baseUrl);

    //Instanciar o page objects
    homePage = new Home(driver);

    //Realiar a busca por um produto e.g. camera
    String nomeProduto = "Camera";
    homePage.insereNomeProdutoCampoPesquisa(nomeProduto);

    //Clicar no botão de busca
    homePage.clicaBotaoPesquisa();


    String tituloPaginaEsperada = "Camera – Praticar Automacao CTG – ESTUDOS";
    String paginaEncontrada = driver.getTitle();

    //Verificar se o titulo encontrado é igual ao esperado
    assertEquals (tituloPaginaEsperada, paginaEncontrada);

}


    @Test
@DisplayName("Quando clicar no botão pesquisar sem inserir nada, então devo ver todos os produtos")
public void pesquisarCampoVazio() {



    //Entrar na página de teste
    //Não inserir nada no campo pesquisa
    //Clicar no botão pesquisar


    }

@BeforeAll
public void setup() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
}

@AfterAll
public void tearDown () {
    driver.close();
}

}
