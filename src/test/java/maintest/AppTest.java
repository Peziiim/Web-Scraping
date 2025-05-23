package maintest;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

import core.Compactor;
import core.Scraping;

public class AppTest {
    private Compactor compactor = new Compactor();
    private Scraping scraping = new Scraping();
 

    private Path path = Path.of("../src/test/java/filestest/");

    @Test
    public void testDownloadFile() throws IOException, URISyntaxException {
        
        String fileUrl = "https://www.unirio.br/cchs/eb/arquivos/tccs-acima-de-9/TCC-%20Ana%20Paula%20Oliveira%20Jacques.pdf/at_download/file";
       
        scraping.downloadFile(fileUrl, path);
        assertTrue(Files.exists(path));

        // Comente a linha abaixo para ver o arquivo guardado na pasta
        Files.deleteIfExists(path);
    }

    @Test
    public void testToZip() throws IOException{

        String stringPath = path.toString();
        compactor.toZipPDF(stringPath, stringPath + ".zip");//

        assertTrue(Files.exists(Path.of(stringPath + ".zip")));

         // Comente a linha abaixo para ver o arquivo guardado na pasta
         Files.deleteIfExists(path);
    
    }

}
