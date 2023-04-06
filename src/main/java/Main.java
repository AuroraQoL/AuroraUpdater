import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Thread.sleep(Integer.parseInt(args[0]));
        File modFile = new File(args[1]);
        if (!modFile.delete()) {
            JOptionPane.showMessageDialog(null, "Update failed! Couldn't delete the file provided.");
        } else {
            FileUtils.copyURLToFile(new URL(args[2].equals("customrepo") ? args[3] : "https://github.com/AuroraQoL/AuroraClient/releases/latest/download/bin.jar"), modFile);
        }
    }
}
