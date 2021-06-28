package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {
    private String name;
    private String dob;
    private String phoneNumber;
    private int age;

    public Contact (String name, String dob, String phoneNumber) throws ParseException{
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone number cannot be null or blank");
        }
        if (phoneNumber.length() < 5) {
            throw new IllegalArgumentException("Phone number must have a length greater than 5...");
        }
        this.name = name;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.age = getNewAge(dob);
    }

    public Contact (Contact source) {
        this.name = source.name;
        this.dob = source.dob;
        this.phoneNumber = source.phoneNumber;
        this.age = source.age;
    }

    public String getName() {
        return this.name;
    }

    public String getDob() {
        return this.dob;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name;
    }

    public void setDob(String dob) throws ParseException {
        this.dob = dob;
        setAge(getNewAge(dob));
        
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone number cannot be null or blank");
        }
        if (phoneNumber.length() < 5) {
            throw new IllegalArgumentException("Phone number must have a length greater than 5...");
        }
        this.phoneNumber = phoneNumber;
    }

    private void setAge(int age) {
       this.age = age;
    }

    public int getNewAge(String dob) throws ParseException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        simpleDateFormat.setLenient(false);
        long ageMilli = new Date().getTime() - simpleDateFormat.parse(dob).getTime();
        long ageDays = TimeUnit.MILLISECONDS.toDays(ageMilli);
        return (int)ageDays/365;
    }

    public String toString() {
        return  "Name: " + this.name + "\n" +
                "Phone number: " + this.phoneNumber + "\n" +
                "Birth Date: " + this.dob + "\n" +
                "Age: " + this.age + " year old\n";
    }

}
