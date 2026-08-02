public class Donor {

    private int id;
    private String fullName;
    private int age;
    private String bloodGroup;
    private String phone;
    private String email;
    private String city;
    private String lastDonation;
    private String availability;

    public Donor() {
    }

    public Donor(String fullName, int age, String bloodGroup,
                 String phone, String email,
                 String city, String lastDonation,
                 String availability) {

        this.fullName = fullName;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.lastDonation = lastDonation;
        this.availability = availability;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLastDonation() {
        return lastDonation;
    }

    public void setLastDonation(String lastDonation) {
        this.lastDonation = lastDonation;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}