/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artificialthing;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class WriteFile {

    String path;
    boolean addToFile = false;

    public WriteFile(String filePath) {
        path = filePath;

    }

    public WriteFile(String filePath, boolean addToFile) {
        path = filePath;
        this.addToFile = addToFile;

    }

    public void WriteToFile(String text) throws IOException {
        System.out.println("made it 1");
        FileWriter write = new FileWriter(path, addToFile);
        System.out.println("made it 2");

        PrintWriter print_line = new PrintWriter(write);
        System.out.println("made it 3");

        print_line.printf("%s" + "%n", text);
        System.out.println("made it 4");

        print_line.close();
        System.out.println("made it 5");

    }
}
