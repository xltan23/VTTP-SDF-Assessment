package vttp.task01;

public class CsvTxtControl {
    
    private String address;
    private String firstName;
    private String lastName; 
    private String years;

    public Template mail;

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

        // Input different rows of strings into the template constructor
        mail = new Template(lines[2], lines[0], lines[3]);
        mail.process(text);
    }

    public void printMail() {
            System.out.printf("%s\n",mail);
    }
}
