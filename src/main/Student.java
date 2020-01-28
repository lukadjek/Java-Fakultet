package main;

import java.time.format.DateTimeFormatter;

public class Student {

    String brojIndeksaStudenta;
    int godinaUpisaStudenta;
    String imeStudenta;
    String prezimeStudenta;
    String nazivPredmeta;
    int ocenaStudenta;
    DateTimeFormatter datumStudenta; // import java.util.Date;
    int IDStudenta;		// povezivanje studenta i predmeta preko ID-ija

    public Student(String brojIndeksaStudenta, int godinaUpisaStudenta, String imeStudenta, String prezimeStudenta, String sifraPredmeta,
            int ocenaStudenta, DateTimeFormatter datumRodjenjaStudenta, int IDStudenta) {

        this.brojIndeksaStudenta = brojIndeksaStudenta;
        this.godinaUpisaStudenta = godinaUpisaStudenta;
        this.imeStudenta = imeStudenta;
        this.prezimeStudenta = prezimeStudenta;
        this.nazivPredmeta = sifraPredmeta;
        this.ocenaStudenta = ocenaStudenta;
        this.datumStudenta = datumRodjenjaStudenta;
        this.IDStudenta = IDStudenta;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Predmet) {
            return false;
        }

        if (obj == null) {
            return false;
        }

        Student other = (Student) obj;

        if (brojIndeksaStudenta.equals(other.brojIndeksaStudenta)) {
            System.out.println("daa");
            return true;
        }

        return false;
    }

    public String getBrojIndeksaStudenta() {
        return brojIndeksaStudenta;
    }

    public void setBrojIndeksaStudenta(String brojIndeksaStudenta) {
        this.brojIndeksaStudenta = brojIndeksaStudenta;
    }

    public int getGodinaUpisaStudenta() {
        return godinaUpisaStudenta;
    }

    public void setGodinaUpisaStudenta(int godinaUpisaStudenta) {
        this.godinaUpisaStudenta = godinaUpisaStudenta;
    }

    public String getImeStudenta() {
        return imeStudenta;
    }

    public void setImeStudenta(String imeStudenta) {
        this.imeStudenta = imeStudenta;
    }

    public String getPrezimeStudenta() {
        return prezimeStudenta;
    }

    public void setPrezimeStudenta(String prezimeStudenta) {
        this.prezimeStudenta = prezimeStudenta;
    }

    public String getSifraPredmeta() {
        return nazivPredmeta;
    }

    public void setSifraPredmeta(String sifraPredmeta) {
        this.nazivPredmeta = sifraPredmeta;
    }

    public int getOcenaStudenta() {
        return ocenaStudenta;
    }

    public void setOcenaStudenta(int ocenaStudenta) {
        this.ocenaStudenta = ocenaStudenta;
    }

    public DateTimeFormatter getDatumRodjenjaStudenta() {
        return datumStudenta;
    }

    public void setDatumRodjenjaStudenta(DateTimeFormatter datumRodjenjaStudenta) {
        this.datumStudenta = datumRodjenjaStudenta;
    }

}
