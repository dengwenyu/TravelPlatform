package xmu.anygo.model;

public class User {
    private int id;
    private String name;
    private String idNumber;
    private String phone;
    private int visitor;
    private String account;
    private String password;
    private int professionalGuide;
    private String location;
    private int creditScore;
    private int serviceScore;
    private int salaryUpperBound;
    private int salaryLowerBound;
    private String information;
    private String image;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getVisitor() {
        return visitor;
    }

    public void setVisitor(int visitor) {
        this.visitor = visitor;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getProfessionalGuide() {
        return professionalGuide;
    }

    public void setProfessionalGuide(int professionalGuide) {
        this.professionalGuide = professionalGuide;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public int getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(int serviceScore) {
        this.serviceScore = serviceScore;
    }

    public int getSalaryUpperBound() {
        return salaryUpperBound;
    }

    public void setSalaryUpperBound(int salaryUpperBound) {
        this.salaryUpperBound = salaryUpperBound;
    }

    public int getSalaryLowerBound() {
        return salaryLowerBound;
    }

    public void setSalaryLowerBound(int salaryLowerBound) {
        this.salaryLowerBound = salaryLowerBound;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
