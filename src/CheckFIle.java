import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.*;

class CheckFile {
    public static void main(String[] args) throws Exception {
        Connection con = null;
        con=connectDb();
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
        }
        catch (Exception e){
            System.out.println("Something went wrong. "+e.getStackTrace());
        }
    }

    private static Connection connectDb() throws SQLException {
        String url="jdbc:mysql://localhost:3306/";
        String username="gdrive";
        String password="practice";
        return DriverManager.getConnection(url, username, password);
    }

    private static void listFilesToTransfer(File[] filesList) {
        for(File files : filesList){
            if(getExtension(files.getName()) != null) {
                double fileSizeInKB = Math.round(((double) files.length() / 1024) * 100.0) / 100.0;
                String formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
                System.out.println(files.getName() +" "+getExtension(files.getName())+" "+fileSizeInKB+" "+formattedDateTime);
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
