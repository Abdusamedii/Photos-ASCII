import javax.swing.*;
import java.io.File;

public class filechooser {
    public File filemethod() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file1 = fileChooser.getSelectedFile();
            return file1;
        }
        return null;
    }

}
