import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(Integer.parseInt(args[0]));
        try {
            Files.copy(new URL(args[2].equals("customrepo") ? args[3] : "https://github.com/AuroraQoL/AuroraClient/releases/latest/download/bin.jar").openStream(), new File(args[1]).toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, new RuntimeException(e).getStackTrace());
        }
        return;
    }
}
