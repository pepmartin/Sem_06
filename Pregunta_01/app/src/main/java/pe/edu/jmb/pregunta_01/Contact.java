package pe.edu.jmb.pregunta_01;

public class Contact {
    private String name;
    private String company;
    private String phoneNumber;

    public Contact() {
    }

    public Contact(String name, String company, String phoneNumber) {
        this.name = name;
        this.company = company;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
