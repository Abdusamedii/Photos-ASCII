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
    public File fileopenmethod(){
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file2 = fileChooser.getSelectedFile();
            return file2;
        }
        return null;
    }


}
