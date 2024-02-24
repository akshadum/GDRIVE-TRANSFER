import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbConfig {
    private static final String PROPERTIES_FILE = "config.properties";
    private static final Properties properties = loadProperties();

    private static Properties loadProperties() {
        try (InputStream configFileReader = DbConfig.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (configFileReader == null) {
                throw new RuntimeException("config.properties not found on the classpath");
            }

            Properties loadedProperties = new Properties();
            loadedProperties.load(configFileReader);

            // Debug: Print loaded properties
            System.out.println("Loaded properties:");
            loadedProperties.forEach((key, value) -> System.out.println(key + ": " + value));

            return loadedProperties;
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties: " + e.getMessage(), e);
        }
    }

    public static String getDbUrl() {
        return getProperty("db.url", "Database URL");
    }

    public static String getDbUsername() {
        return getProperty("db.username", "Database username");
    }

    public static String getDbPassword() {
        return getProperty("db.password", "Database password");
    }

    private static String getProperty(String key, String propertyName) {
        String propertyValue = properties.getProperty(key);
        if (propertyValue == null) {
            throw new RuntimeException(propertyName + " is missing in " + PROPERTIES_FILE);
        }
        return propertyValue;
    }
}
