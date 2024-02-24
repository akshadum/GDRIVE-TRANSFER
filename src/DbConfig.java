import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbConfig {
    private static final String PROPERTIES_FILE = "db.properties";
    private static Properties properties = new Properties();

    DbConfig() {
        try (InputStream input = DbConfig.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + PROPERTIES_FILE);
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getDbUrl() {
        return properties.getProperty("db.url");
    }

    public static String getDbUsername() {
        return properties.getProperty("db.username");
    }

    public static String getDbPassword() {
        return properties.getProperty("db.password");
    }
}
