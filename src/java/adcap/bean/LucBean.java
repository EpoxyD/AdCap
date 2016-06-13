/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.bean;

/**
 *
 * @author Karsten
 */
public class LucBean {
    String nr;
    String gender;
    String surname;
    String preferredMailAdress;
    String preferredName;
    String facultyAffiliation;

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPreferredMailAdress() {
        return preferredMailAdress;
    }

    public void setPreferredMailAdress(String preferredMailAdress) {
        this.preferredMailAdress = preferredMailAdress;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public String getFacultyAffiliation() {
        return facultyAffiliation;
    }

    public void setFacultyAffiliation(String facultyAffiliation) {
        this.facultyAffiliation = facultyAffiliation;
    }
  
}
