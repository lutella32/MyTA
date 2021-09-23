package com.example.myta;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;


public class Person implements Parcelable {


    public enum Genre{man, woman, undifined};
    public enum Age{LessThan40, between40and60, more60};
    public enum Imc{yes, no, IDontKnow};
    public enum ParentPb{yes, no, maybe};

    private String name;
    private Genre genre;
    private Age age;
    private Imc imc;
    private ParentPb parentPb;
    private Boolean cardiacDisease, cholestPb, diab, hypertension, doctor, checkpoint, appointment;

    public static final String DEFAULT_NAME="UNDIFINED";

    public Person(){
        this.setName(Person.DEFAULT_NAME);
        this.setGenre(Genre.undifined);
        this.setAge(Age.LessThan40);
        this.setImc(Imc.IDontKnow);
        this.setParentPb(ParentPb.maybe);
        this.setCardiacDisease(false);
        this.setCholestPb(false);
        this.setDiab(false);
        this.setHypertension(false);
        this.setDoctor(false);
        this.setCheckpoint(false);
        this.setAppointment(false);
    }

    @NonNull
    public String toString(){
        StringBuilder sBuilder = new StringBuilder("\t Name: " + this.getName() + "\n");
        sBuilder.append("\t Genre: ").append(this.getGenre()).append("\n");
        sBuilder.append("\t Age: ").append(this.getAge()).append("\n");
        sBuilder.append("\t IMC: ").append(this.getImc()).append("\n");
        sBuilder.append("\t Any parent with cardiac problem: ").append(this.getParentPb()).append("\n");
        sBuilder.append("\t Cardiac disease: ").append(this.getCardiacDisease()).append("\n");
        sBuilder.append("\t Cholesterol: ").append(this.getCholestPb()).append("\n");
        sBuilder.append("\t Diabete: ").append(this.getDiab()).append("\n");
        sBuilder.append("\t Hypertention: ").append(this.getHypertension()).append("\n");
        sBuilder.append("\t Talking about your heart with a doctor: ").append(this.getDoctor()).append("\n");
        sBuilder.append("\t Heart checkpoint: ").append(this.getCheckpoint()).append("\n");
        sBuilder.append("\t Appointment with a cardioligist: ").append(this.getAppointment()).append("\n");
        return sBuilder.toString();
    }

    public void print(){
        System.out.println("Person's attributes: ");
        System.out.print(this);
        System.out.println();
    }



    //Getter / Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    //Getter setter age
    public Age getAge() { return age; }
    public void setAge(Age age) { this.age = age; }

    public Genre getGenre() { return genre; }
    public void setGenre(Genre genre) { this.genre = genre; }

    public Imc getImc() { return imc; }
    public void setImc(Imc imc) { this.imc = imc; }

    public ParentPb getParentPb() { return parentPb; }
    public void setParentPb(ParentPb parentPb) { this.parentPb = parentPb; }

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
    public Boolean getDoctor() { return doctor;}
    public void setDoctor(Boolean doctor) { this.doctor = doctor; }

    //Getter setter heart checkpoint
    public Boolean getCheckpoint() { return checkpoint; }
    public void setCheckpoint(Boolean checkpoint) { this.checkpoint = checkpoint; }

    //Getter setter appointment with cardiologist
    public Boolean getAppointment() { return appointment; }
    public void setAppointment(Boolean appointment) { this.appointment = appointment; }

    @Override
    public int describeContents() { return 0; }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.getName());
        dest.writeInt(this.getGenre().ordinal());
        dest.writeInt(this.getAge().ordinal());
        dest.writeInt(this.getImc().ordinal());
        dest.writeInt(this.getParentPb().ordinal());

        //dest.writeBoolean() requires API 29
/*        dest.writeBoolean(this.getCardiacDisease());
        dest.writeBoolean(this.getCholestPb());
        dest.writeBoolean(this.getDiab());
        dest.writeBoolean(this.getDoctor());
        dest.writeBoolean(this.getCheckpoint());
        dest.writeBoolean(this.getAppointment());
        dest.writeBoolean(this.getHypertension());*/
    }

    public static final Parcelable.Creator<Person> CREATOR
            = new Parcelable.Creator<Person>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.Q)
    private Person(Parcel in) {
        this.setName(in.readString());
        this.setGenre(Genre.values()[in.readInt()]);
        this.setAge(Age.values()[in.readInt()]);
        this.setImc(Imc.values()[in.readInt()]);
        this.setParentPb(ParentPb.values()[in.readInt()]);
/*        this.setCholestPb(in.readBoolean());
        this.setCardiacDisease(in.readBoolean());
        this.setDoctor(in.readBoolean());
        this.setDiab(in.readBoolean());
        this.setCheckpoint(in.readBoolean());
        this.setHypertension(in.readBoolean());
        this.setAppointment(in.readBoolean());*/
    }

}
