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

        Path fileName3 = Path.of("imagefile.md");
        String contents3 = Files.readString(fileName3);
        ArrayList<String> links6 = MarkdownParse.getLinks(contents3);
        ArrayList<String> links7 = new ArrayList<String>();
        links7.add("https://something.com");
        links7.add("some-page.html");
        assertEquals(links7, links6);
    }

    @Test 
    public void snippet1Test() throws IOException {
        Path fileName4 = Path.of("snippet1.md");
        String contents4 = Files.readString(fileName4);
        ArrayList<String> links8 = MarkdownParse.getLinks(contents4);
        ArrayList<String> links9 = new ArrayList<String>();
        links9.add("`google.com");
        links9.add("google.com");
        links9.add("ucsd.edu");
        assertEquals(links9, links8);
    }

    @Test 
    public void snippet2Test() throws IOException {
        Path fileName5 = Path.of("snippet2.md");
        String contents5 = Files.readString(fileName5);
        ArrayList<String> links10 = MarkdownParse.getLinks(contents5);
        ArrayList<String> links11 = new ArrayList<String>();
        links11.add("a.com");
        links11.add("a.com(())");
        links11.add("example.com");
        assertEquals(links11, links10);
    }

    @Test 
    public void snippet3Test() throws IOException {
        Path fileName6 = Path.of("snippet3.md");
        String contents6 = Files.readString(fileName6);
        ArrayList<String> links12 = MarkdownParse.getLinks(contents6);
        ArrayList<String> links13 = new ArrayList<String>();
        links13.add("https://ucsd-cse15l-w22.github.io/");
        assertEquals(links13, links12);
    }
}