package com.example.myta;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;


public class Person implements Parcelable {

    private String name;//, parentWthPb, IMC;
    //private Boolean genre;
    private Integer age;
    //private Boolean cardiacDisease, cholestPb, diab, hypertension, doctor, checkpoint, appointment;

    public static final String DEFAULT_NAME="UNDIFINED";

    public Person(){
        this.setName(Person.DEFAULT_NAME);
        this.setAge(0);
    }

    public String toString(){
        StringBuilder sBuilder = new StringBuilder("\t Name: " + this.getName() + "\n");
        sBuilder.append("\t Age: ").append(this.getAge()).append("\n");
        return sBuilder.toString();
    }

    public void print(){
        System.out.println("Person's attributes: ");
        System.out.print(this);
        System.out.println();
    }


    /*
        Getter / Setter
     */
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    //Getter setter age
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.getName());
        dest.writeInt(this.getAge());
    }

    public static final Parcelable.Creator<Person> CREATOR
            = new Parcelable.Creator<Person>() {
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    private Person(Parcel in) {
        this.setName(in.readString());
        this.setAge(in.readInt());
    }
/*
    //Getter setter Prent with cardiac problem
    public String getParentWthPb() { return parentWthPb; }
    public void setParentWthPb(String parentWthPb) { this.parentWthPb = parentWthPb; }

    //Getter setter IMC
    public String getIMC() { return IMC; }
    public void setIMC(String IMC) { this.IMC = IMC; }

    //Getter setter genre
    public Boolean getGenre() { return genre; }
    public void setGenre(Boolean genre) { this.genre = genre; }

    //Getter setter cardiac disease
    public Boolean getCardiacDisease() { return cardiacDisease; }
    public void setCardiacDisease(Boolean cardiacDisease) { this.cardiacDisease = cardiacDisease; }

    //Getter setter cholesterol problem
    public Boolean getCholestPb() { return cholestPb; }
    public void setCholestPb(Boolean cholestPb) { this.cholestPb = cholestPb; }

    //Getter setter diabete
    public Boolean getDiab() { return diab; }
    public void setDiab(Boolean diab) { this.diab = diab;  }

    //Getter setter hypertension
    public Boolean getHypertension() { return hypertension; }
    public void setHypertension(Boolean hypertension) { this.hypertension = hypertension; }

    //Getter setter talk with a doctor about cardiac diseases
    public Boolean getDoctor() {
        return doctor;
    }
    public void setDoctor(Boolean doctor) {
        this.doctor = doctor;
    }

    //Getter setter heart checkpoint
    public Boolean getCheckpoint() {
        return checkpoint;
    }
    public void setCheckpoint(Boolean checkpoint) {
        this.checkpoint = checkpoint;
    }

    //Getter setter appointment with cardiologist
    public Boolean getAppointment() {
        return appointment;
    }
    public void setAppointment(Boolean appointment) {
        this.appointment = appointment;
    }
*/


}
