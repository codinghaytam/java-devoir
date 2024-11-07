package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JsonUtilsTest {

    static class TestObject {
        private String name;
        private int age;

        public TestObject(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Getters are needed for JSON serialization
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    @Test
    public void testToJsonWithValidObject() {
        TestObject testObject = new TestObject("Alice", 30);
        String json = JsonUtils.toJson(testObject);

        // Verify that the JSON string contains expected fields and values
        assertNotNull(json, "JSON result should not be null");
        assertTrue(json.contains("\"name\":\"Alice\""));
        assertTrue(json.contains("\"age\":30"));
    }

    @Test
    public void testToJsonWithNullObject() {
        String json = JsonUtils.toJson(null);
        assertNull(json, "JSON result should be null when the input is null");
    }

    @Test
    public void testToJsonWithEmptyObject() {
        TestObject emptyObject = new TestObject(null, 0);
        String json = JsonUtils.toJson(emptyObject);
        assertNotNull(json, "JSON result should not be null for empty object");
        assertTrue(json.contains("\"age\":0"));
    }
}
