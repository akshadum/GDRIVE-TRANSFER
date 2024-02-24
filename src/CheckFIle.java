import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;

class CheckFile {
    private static final String INSERT_INTO_DB = "INSERT INTO AUDIT (NAME, EXTENSION, SIZE, TRANSFER_DTM) VALUES (?,?,?,?);";
    public static void main(String[] args) throws Exception {

        String directoryPath = "C:/karan/just/Gdrive_project/TRANSFER/";
        File directory = new File(directoryPath);

        try {
            if (!directory.exists()) {
                System.out.println("Directory not found: " + directoryPath);
            } else {
                File[] filesList = directory.listFiles();
                if (filesList != null && filesList.length != 0) {
                    System.out.println("Total " + filesList.length + " File(s) available to transfer.");
                    listFilesToTransfer(filesList);
                } else
                    System.out.println("No Files available to transfer.");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong. ");
            throw new IOException(e);
        }
    }

    private static Connection connectDb() throws SQLException {
        String url = DbConfig.getDbUrl();
        String username = DbConfig.getDbUsername();
        String password = DbConfig.getDbPassword();
        return DriverManager.getConnection(url, username, password);
    }

    private static void listFilesToTransfer(File[] filesList) throws SQLException {
        Connection con;
        PreparedStatement ps = null;
        con = connectDb();
        System.out.println("Connection Success");
        try {
            ps = con.prepareStatement(INSERT_INTO_DB);
            for (File files : filesList) {
                if (getExtension(files.getName()) != null) {
                    double fileSizeInKB = Math.round(((double) files.length() / 1024) * 100.0) / 100.0;
                    ps.setString(1, files.getName());
                    ps.setString(2, getExtension(files.getName()));
                    ps.setDouble(3, fileSizeInKB);
                    ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
                    ps.executeUpdate();
                    System.out.println(files.getName() + " " + getExtension(files.getName()) + " " + fileSizeInKB + " " + Timestamp.valueOf(LocalDateTime.now()));
                }
            }
        } finally {
            con.close();
            try {
                if (ps != null)
                    ps.close();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex != -1 && lastDotIndex < fileName.length() - 1) {
            return fileName.substring(lastDotIndex );
        }
        return null;
    }
}
