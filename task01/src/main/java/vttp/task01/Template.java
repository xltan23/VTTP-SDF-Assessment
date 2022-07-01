package vttp.task01;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;

public class Template {

    // Setting up members
    private String address;
    private String firstName;
    private String lastName;
    private String years;

    // Constructor that takes in inputs for templates with only these parameters
    public Template(String adrs, String fn, String y) {
        this.address = adrs;
        this.firstName = fn;
        this.years = y;
    }
    
    // Constructor that takes in inputs for templates with all parameters
    public Template(String adrs, String fn, String ln, String y) {
        this.address = adrs;
        this.firstName = fn;
        this.lastName = ln;
        this.years = y;
    }

    // Creating template that takes in template parameters to replace __Variables__ in text
    public String process(String text) {   
        try {
            if (null == text) {
                return;
            }
            if (text.contains("__address__")) {
                text.replaceAll("__address__", address);
            } else if (text.contains("__first_name__")) {
                text.replaceAll("__first_name__", firstName);
            } else if (text.contains("__last_name__")) {
                text.replaceAll("__last_name__", lastName);
            } else if (text.contains("__years__")) {
                text.replaceAll("__years__", years);
            } else {
                ;
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return text;
    }

}
