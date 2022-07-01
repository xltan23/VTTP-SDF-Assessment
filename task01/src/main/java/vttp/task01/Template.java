package vttp.task01;

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
        text.replaceAll("__address__", address);
        text.replaceAll("__first_name__", firstName);
        text.replaceAll("__last_name__", lastName);
        text.replaceAll("__years__", years);
        return text;
    }

}
