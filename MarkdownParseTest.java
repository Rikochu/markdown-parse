import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// imports the junit classes and methods

public class MarkdownParseTest {
    @Test
    // indicates that the method is a tester method
    public void addition() {
        assertEquals(2, 1 + 1);
        // checks if the first parameter is equal to the second
        // parameter
    }

    @Test 
    public void markdownTest() throws IOException {
        Path fileName = Path.of("noText.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        ArrayList<String> links5 = new ArrayList<String>();
        assertEquals(links5, links);

        Path fileName1 = Path.of("fileWithSpace.md");
        String contents1 = Files.readString(fileName1);
        ArrayList<String> links1 = MarkdownParse.getLinks(contents1);
        ArrayList<String> links3 = new ArrayList<String>();
        links3.add("https://ucsd-cse15l-w22.github.io/week/week3/");
        assertEquals(links3, links1);
        
        /** */
        Path fileName2 = Path.of("loop.md");
        String contents2 = Files.readString(fileName2);
        ArrayList<String> links2 = MarkdownParse.getLinks(contents2);
        ArrayList<String> links4 = new ArrayList<String>();
        links4.add("https://ucsd-cse15l-w22.github.io/week/week3/");
        links4.add("some-page.html");
        assertEquals(links4, links2);
    }
}