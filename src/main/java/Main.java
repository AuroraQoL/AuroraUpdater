import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Wait for game to turn off (5 seconds is enough I think)
        Thread.sleep(5000);
        // Delete old mod file
        File modFile = new File(args[0]);
        if (!modFile.delete()) {
            JOptionPane.showMessageDialog(null, "Update failed! Couldn't delete the file provided.");
            return;
        }
        // Download mod
        switch(args[1]){
            // Main repository download
            case "mainrepo":
                FileUtils.copyURLToFile(new URL("https://github.com/OctoSplash01/AuroraClient/releases/latest/download/bin.jar"), modFile);
                break;
            // Custom repository download
            case "customrepo":
                FileUtils.copyURLToFile(new URL(args[2]), modFile);
                break;
        }
        // Status notify
        JOptionPane.showMessageDialog(null, "Updated Aurora!");
    }
}