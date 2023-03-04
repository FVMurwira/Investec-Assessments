package models;

public class client {

    private String  firstName;
    private String  lastName;
    private String  email;
    private Boolean mySelf = false;
    private Boolean interMediaries  = false;
    private Boolean myBusiness  = false;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getMySelf() {
        return this.mySelf;
    }

    public void setMySelf(Boolean mySelf) {
        this.mySelf = mySelf;
    }

    public Boolean getInterMediaries() {
        return this.interMediaries;
    }

    public void setInterMediaries(Boolean interMediaries) {
        this.interMediaries = interMediaries;
    }

    public Boolean getMyBusiness() {
        return this.myBusiness;
    }

    public void setMyBusiness(Boolean myBusiness) {
        this.myBusiness = myBusiness;
    }

}
