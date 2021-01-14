package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import uk.co.evoco.utils.JsonUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class JsonUtilsTests {

    private static final String FILE = "fixtures/test.json";

    @Test
    public void testFromFileWithTestClass() throws IOException {
        File file = loadFile(FILE);
        TestObject testObject = JsonUtils.fromFile(file, TestObject.class);
        assertThat(testObject.getField1(), is("test1"));
    }

    @Test
    public void testFromFileWithTestTypeReference() throws IOException {
        File file = loadFile(FILE);
        TestObject testObject = JsonUtils.fromFile(file, new TypeReference<>() {
        });
        assertThat(testObject.getField1(), is("test1"));
    }

    @Test
    public void testFromFileWithTestClassFromInputStream() throws IOException {
        InputStream is = ClassLoader.getSystemResourceAsStream(FILE);
        TestObject testObject = JsonUtils.fromFile(is, TestObject.class);
        assertThat(testObject.getField1(), is("test1"));
    }

    @Test
    public void testFromFileWithTestClassFromString() throws IOException {
        TestObject testObject = JsonUtils.fromFile(ClassLoader.getSystemResource(FILE).getPath(),
                TestObject.class);
        assertThat(testObject.getField1(), is("test1"));
    }

    @Test
    public void testToStringOnObject() throws IOException {
        TestObject testObject = JsonUtils.fromFile(ClassLoader.getSystemResource(FILE).getPath(),
                TestObject.class);
        assertThat(JsonUtils.toString(testObject), is("{\"field1\":\"test1\",\"field2\":\"test2\"}"));
    }

    private File loadFile(String path) throws IOException {
        File file = new File(path);
        if (file.isFile()) {
            return file;
        } else {
            try {
                return new File(ClassLoader.getSystemResource(path).getPath());
            } catch(NullPointerException e) {
                throw new IOException("File could not be found: " + path);
            }
        }
    }
}

class TestObject {
    private String field1;
    private String field2;

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }
}
