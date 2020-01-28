package main;

public class Predmet {

    String sifraPredmeta;
    String nazivPredmetaaaa;
    int IDPredmeta;
    static int nizPredmeti[];

    public Predmet(String sifraPredmeta, String nazivPredmeta, int IDPredmeta) {

        this.sifraPredmeta = sifraPredmeta;
        this.nazivPredmetaaaa = nazivPredmeta;
        this.IDPredmeta = IDPredmeta;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getSifraPredmeta() {
        return sifraPredmeta;
    }

    public void setSifraPredmeta(String sifraPredmeta) {
        this.sifraPredmeta = sifraPredmeta;
    }

    public String getNazivPredmeta() {
        return nazivPredmetaaaa;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmetaaaa = nazivPredmeta;
    }

}
