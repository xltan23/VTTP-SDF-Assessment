package vttp.task01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {
    public static void main( String[] args ) throws FileNotFoundException, IOException {
        // .csv as data source
        String srcFile = args[0]; 
        // .txt as template
        String template = args[1];

        // Reading csv data
        Reader r = new FileReader(srcFile);
        BufferedReader br = new BufferedReader(r);
        String data = br.readLine();

        // Reading txt data
        Reader tr = new FileReader(template);
        BufferedReader tbr = new BufferedReader(tr);
        String text = tbr.readLine();

        CsvTxtControl ctc = new CsvTxtControl();
        
        // For processing
        // Attempting to remove null line at end of csv file (Null is inputted into the template)
        while (data != null && data.split(",").length > 0) {
            data = br.readLine();
            while (text != null) {
                text = tbr.readLine();
                // ctc should contain 7 different mails
                ctc.read(data, text);
            }
        }
        ctc.printMail();
    }
}
