/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artificialthing;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ArtificialThing {

    public static void main(String[] args) throws IOException{
        String file_name = "C:\\Users\\j.head\\Desktop\\Text\\save.txt";
        WriteFile data = new WriteFile(file_name, true);
        data.WriteToFile("muahahahahah");
        data.WriteToFile("muahahahahah");
        data.WriteToFile("muahahahahah");
        
//        FileReader fr = new FileReader(file_name);
//        System.out.println((char)fr.read());
        File file = new File(file_name);
        Scanner scanner = new Scanner(file);
        System.out.println(scanner.nextLine());
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.contains("m"))
            {
                System.out.println("made it ");
            }
        }
    }

}
