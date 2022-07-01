package vttp.task01;

import java.util.LinkedList;
import java.util.List;

public class CsvTxtControl {
    
    // Setting up members
    private String address;
    private String firstName;
    private String lastName; 
    private String years;
    private List<String> info = new LinkedList<>();

    public Template mail;

    // Default constructor
    public CsvTxtControl() {
        ;
    }

    public void read(String data, String text) {
        if (null == data) {
            return;
        }
        // Setting up such that lines[0] = first_name, lines[1] = last_name, lines[2] = address, lines[3] = years
        String[] lines = data.split(",");
        lines[0] = firstName;
        lines[1] = lastName;
        lines[2] = address;
        lines[3] = years;

        general(lines[0],lines[1],lines[2],lines[3]);

        for (int i = 0; i < info.size(); i++) {
            if (info.get(i) != null) {
                // Deploy Template constructor to take in Strings 
                mail = new Template(info.get(2), info.get(0), info.get(3));
                mail.process(text);
            }
        }
        System.out.printf("%s\n",mail);
    }

    // Create list to store the strings
    private void general(String fn, String ln, String adrs, String y) {
        info.add(fn);
        info.add(ln);
        info.add(adrs);
        info.add(y);
    } 

}
