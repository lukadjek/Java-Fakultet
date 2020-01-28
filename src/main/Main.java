package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static int opcija;

    static Predmet p1 = new Predmet("101b", "Ekonomija", 500); // Ekonomija sifra = 500
    static Predmet p2 = new Predmet("102a", "Nemacki", 600); // Nemacki sifra 600;
    static Predmet p3 = new Predmet("104c", "Francuski", 650); // Francuski sifra 650;

    static LocalDate trenutniDatum = LocalDate.now();
    static DateTimeFormatter formatirajTrenutniDatum = DateTimeFormatter.ofPattern("dd-LL-yyyy");
    static String noviDatumNakonFormatiranja = trenutniDatum.format(formatirajTrenutniDatum);

    static Student s4 = new Student("f210", 2012, "ilija", "rasinac", "Nemacki", 8, formatirajTrenutniDatum, 600);
    static Student s1 = new Student("f200", 2010, "pavle", "pesic", "Ekonomija", 6, formatirajTrenutniDatum, 500);
    static Student s2 = new Student("f212", 2012, "nikola", "nikolic", "Francuski", 5, formatirajTrenutniDatum, 650);
    static Student s3 = new Student("f234", 2012, "dusan", "markovic", "Francuski", 9, formatirajTrenutniDatum, 650);

    static Student nizStudenti[] = {s4, s1, s2, s3};
    static Predmet nizPredmeti[] = {p1, p2, p3};

    public static void main(String[] args) {

        int maxOpcija = 6;
        int minOpcija = 1;

        do {

            opcija = PrihvatiUlaz.prihvatiBroj();

            switch (opcija) {
                case 0:
                    PrihvatiUlaz.ispitajKraj();
                    break;
                case 1:
                    pregledSvihPredmeta();
                    break;
                case 2:
                    pregledSvihStudenata();
                    break;
                case 3:
                    pregledSvihPrijavaZaTrazenogStudenta();
                    break;
                case 4:
                    prikazStudenataKojiSuPoloziliPredmet();
                    break;
                case 5:
                    unosNovePrijave();
                    break;
                case 6:
                    izmenaPodatakaOStudentu();
                    break;
                default:
                    if (opcija != 0) {
                        System.out.println("Uneli ste broj: " + opcija);
                        IspitajGreske.brojGresaka();
                    }
                    break;
            }

        } while ((opcija > maxOpcija) || (opcija < minOpcija) || (opcija != 0));

    }

    public static void pregledSvihPredmeta() {

        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __");

        System.out.println("Svi predmeti su...");

        System.out.println("--------------------------------------------------------------");
        System.out.printf("%10s %20s %20s", "Redni broj predmeta", "Sifra predmeta", "Naziv predmeta");
        System.out.println();
        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < nizPredmeti.length; i++) {
            System.out.printf("%10s %22.5s %25s %1s", (i + 1), nizPredmeti[i].sifraPredmeta,
                    nizPredmeti[i].nazivPredmetaaaa, "\n");
            if (i == nizPredmeti.length - 1) {
                System.out.println("--------------------------------------------------------------");
                System.out.print("...i vise nema predmeta.");
            }

        }
        System.out.println(" Ukupan broj predmeta je: " + nizPredmeti.length);

    }

    public static void pregledSvihStudenata() {

        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __");

        System.out.println("Svi studenti su (obavezno iskljuciti \"word wrap\" opciju da bi prikaz bio cist):");

        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %20s %20s %13.5s %22s %25s %15s %22s", "Redni broj predmeta", "Broj indeksa",
                "Godina upisa", "Ime", "Prezime", "Naziv predmeta", "Ocena", "Datum (danasnji)");
        System.out.println();
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        int redniBroj = 1;
        for (Student element : nizStudenti) {

            System.out.printf("%10s %24s %20s %20s %20s %20s %18s %22s", redniBroj, element.brojIndeksaStudenta,
                    element.godinaUpisaStudenta,
                    element.imeStudenta.substring(0, 1).toUpperCase() + element.imeStudenta.substring(1).toLowerCase(),
                    element.prezimeStudenta.substring(0, 1).toUpperCase()
                    + element.prezimeStudenta.substring(1).toLowerCase(),
                    element.nazivPredmeta, element.ocenaStudenta, noviDatumNakonFormatiranja);
            System.out.println();
            redniBroj++;

        }
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("Ukupan broj studenata je: " + (redniBroj - 1));

    }

    public static void pregledSvihPrijavaZaTrazenogStudenta() {

        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __");

        System.out.print("Unesite broj indeksa kako bi proverili da li isti postoji u sistemu: ");
        Scanner in = new Scanner(System.in);
        String prihvatiBrojIndeksa = in.nextLine();

        int prikaziBrojKolikoIhIma = 0;
        for (int i = 0; i < nizStudenti.length; i++) {

            if (nizStudenti[i].brojIndeksaStudenta.equals(prihvatiBrojIndeksa)) {
                prikaziBrojKolikoIhIma++;
            }
        }

        if (prihvatiBrojIndeksa.strip().equals("") && (prikaziBrojKolikoIhIma == 0)) {
            System.out.println("\t Niste ni uneli broj indeksa!");
        } else if (prikaziBrojKolikoIhIma == 0) {
            System.out.println("\t Nema nijednog studenta sa indeksom: \"" + prihvatiBrojIndeksa
                    + "\". Uvid u brojeve indeksa studenata mozete naci u pregledu svih studenata.");
        } else if (prikaziBrojKolikoIhIma == 1) {
            System.out.println(
                    "\t " + prikaziBrojKolikoIhIma + " student ima taj broj indeksa: \"" + prihvatiBrojIndeksa + "\".");
        } else {
            System.out.println("\t " + prikaziBrojKolikoIhIma + " studenta imaju taj broj indeksa: \""
                    + prihvatiBrojIndeksa + "\"."); // u slucaju da vise studenata ima isti broj indeksa...nepotrebno
        }													// zapravo, ali neka stoji

        for (int i = 0; i < nizStudenti.length; i++) {

            if (nizStudenti[i].brojIndeksaStudenta.equals(prihvatiBrojIndeksa)) {
                System.out.println("\t Ime i prezime: " + nizStudenti[i].imeStudenta.substring(0, 1).toUpperCase()
                        + nizStudenti[i].imeStudenta.substring(1).toLowerCase() + " "
                        + nizStudenti[i].prezimeStudenta.substring(0, 1).toUpperCase()
                        + nizStudenti[i].prezimeStudenta.substring(1).toLowerCase() + ", a prijavio je ispit: "
                        + nizStudenti[i].nazivPredmeta.substring(0, 1).toUpperCase()
                        + nizStudenti[i].nazivPredmeta.substring(1).toLowerCase() + ".");
            }
        }

    }

    public static void prikazStudenataKojiSuPoloziliPredmet() {
        boolean imaLiTeSifreCuvene = false;
        boolean praznaSifra = false;
        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __");

        System.out.print("Unesi sifru predmeta kako bi proverili da li postoji isti u sistemu: ");
        Scanner in = new Scanner(System.in);
        String prihvatiSifruPredmeta = in.nextLine();

        if (prihvatiSifruPredmeta.strip().equals("")) {
            System.out.println("\t Niste ni uneli sifru predmeta!");
            praznaSifra = true;
        } else {
            for (int i = 0; i < nizPredmeti.length; i++) {

                if (nizPredmeti[i].sifraPredmeta.equalsIgnoreCase(prihvatiSifruPredmeta)) {
                    System.out.println("\t Da, imamo tu sifru u sistemu \"" + prihvatiSifruPredmeta + "\".");

                    for (int j = 0; j < nizStudenti.length; j++) {

                        if ((nizPredmeti[i].IDPredmeta == (nizStudenti[j].IDStudenta))) {
                            System.out.println(
                                    "\t Podaci o studentu: " + nizStudenti[j].imeStudenta.substring(0, 1).toUpperCase()
                                    + nizStudenti[j].imeStudenta.substring(1).toLowerCase() + " "
                                    + nizStudenti[j].prezimeStudenta.substring(0, 1).toUpperCase()
                                    + nizStudenti[j].prezimeStudenta.substring(1).toLowerCase()
                                    + ", a predmet koji je prijavio je: " + nizStudenti[j].nazivPredmeta + ".");
                            imaLiTeSifreCuvene = true;

                            if (nizStudenti[j].ocenaStudenta >= 6) {
                                System.out.println("\t On srecom jeste polozio taj ispit. Dobio je ocenu: "
                                        + nizStudenti[j].ocenaStudenta);
                            } else {
                                System.out.println("\t On nazalost nije polozio taj ispit. Dobio je ocenu: "
                                        + nizStudenti[j].ocenaStudenta);
                            }

                        }

                    }

                }

            }
        }
        if ((imaLiTeSifreCuvene == false) && (praznaSifra == false)) {
            System.out.println("\t Ne postoji sifra \"" + prihvatiSifruPredmeta
                    + "\" u nasem sistemu. Uvid u sifre predmeta mozete naci u pregledu svih predmeta.");

        }

    }

    public static void unosNovePrijave() {

        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __");
        System.out.println(
                "Ovde imate opciju da unesete novu ocenu studenta samo za predmet koji je on prvobitno polagao.");

        // Sifra predmeta
        System.out.println("***Primer: 101b");
        System.out.print("Unesite sifru predmeta: ");

        Scanner in2 = new Scanner(System.in);
        String sifraPredmetaNova = in2.nextLine();

        while (sifraPredmetaNova.strip().equals("")) {
            System.out.print("\t Uneli ste praznu sifru predmeta. Morate uneti neku vrednost: ");
            sifraPredmetaNova = in2.nextLine();
        }

        System.out.println("\t Sifra predmeta ispravno uneta: \"" + sifraPredmetaNova + "\".");
        System.out.println("----------------");

        // Broj indeksa studenta
        System.out.println("***Primer: f200");
        System.out.print("Unesite broj indeksa studenta: ");

        Scanner in3 = new Scanner(System.in);
        String indeksStudenta = in3.nextLine();

        while (indeksStudenta.strip().equals("")) {
            System.out.print("\t Uneli ste prazan indeks studenta. Morate uneti neku vrednost: ");
            indeksStudenta = in3.nextLine();
        }

        System.out.println("\t Indeks ispravno unet: \"" + indeksStudenta + "\".");
        System.out.println("----------------");

        // Datum polaganja ispita
        boolean ispravnostDatuma = false;
        while (!ispravnostDatuma) {

            DateTimeFormatter formatirajTrenutniDatum = DateTimeFormatter.ofPattern("dd-LL-yyyy");

            System.out.println("***Primer: 03-08-1993");
            System.out.print("Unesite datum (u formatu koji je gore naveden): ");
            Scanner in = new Scanner(System.in);
            String prihvatiDatum = in.nextLine();

            try {
                TemporalAccessor date = formatirajTrenutniDatum.parse(prihvatiDatum);
                System.out.println("Datum ispravno unet: \"" + formatirajTrenutniDatum.format(date) + "\"");
                System.out.println("----------------");
                ispravnostDatuma = true;

            } catch (DateTimeParseException e) {
                if (!prihvatiDatum.strip().equals("")) {
                    System.out.println("\t Uneli ste neispravan format datuma: \"" + e.getParsedString() + "\"");
                } else {
                    System.out.println("\t Niste ni uneli datum...");
                }
            }

        }

        // Ocena na ispitu
        boolean ispravnostOcene = false;
        while (!ispravnostOcene) {

            System.out.println("***Ocena mora biti u rangu 5-10");
            System.out.print("Unesite novu ocenu studenta: ");

            try {

                Scanner in = new Scanner(System.in);
                int ocena = in.nextInt();

                if ((ocena >= 5) && (ocena <= 10)) {
                    System.out.println("Nova ocena ispravno unet: " + ocena);
                    ispravnostOcene = true;

                    // prikazi sve podatke
                    System.out.println(" = ");
                    System.out.println("Dakle, mali rezime, Vi ste uneli sledece podatke: \n \t sifra predmeta: \""
                            + sifraPredmetaNova + "\", indeks studenta: \"" + indeksStudenta + "\""
                            + ", ocena studenta: \"" + ocena + "\".");

                    System.out.println(
                            "U toku je provera da li student i sifra predmeta postoje u sistemu, kao i da li je nova ocena studenta sada veca od prethodne za taj predmet sa tom sifrom. Molimo za malo strpljenja...");

                    boolean ocenaResena = false;
                    boolean postojiOsoba = false;

                    for (int i = 0; i < nizStudenti.length; i++) {

                        for (int j = 0; j < nizPredmeti.length; j++) {

                            if ((nizStudenti[i].brojIndeksaStudenta.equals(indeksStudenta))
                                    && (nizPredmeti[j].sifraPredmeta.equals(sifraPredmetaNova))) {

                                postojiOsoba = true;

                                if (nizStudenti[i].IDStudenta == nizPredmeti[j].IDPredmeta) {

                                    if (ocena > nizStudenti[i].ocenaStudenta) {

                                        if (nizStudenti[i].ocenaStudenta <= 5) {
                                            System.out.println("\t Student "
                                                    + nizStudenti[i].imeStudenta.substring(0, 1).toUpperCase()
                                                    + nizStudenti[i].imeStudenta.substring(1).toLowerCase() + " "
                                                    + nizStudenti[i].prezimeStudenta.substring(0, 1).toUpperCase()
                                                    + nizStudenti[i].prezimeStudenta.substring(1).toLowerCase()
                                                    + " tada nije ni polozio ispit sa ocenom "
                                                    + nizStudenti[i].ocenaStudenta + ", iz predmeta "
                                                    + nizStudenti[i].nazivPredmeta + ".");
                                            System.out
                                                    .println("\t Ucio je, borio se, pa stoga i sada dobio novu ocenu: "
                                                            + ocena + ". Nova ocena " + ocena + " je upisana.");
                                            nizStudenti[i].ocenaStudenta = ocena;
                                            ocenaResena = true;
                                        } else {
                                            System.out.println("\t Student "
                                                    + nizStudenti[i].imeStudenta.substring(0, 1).toUpperCase()
                                                    + nizStudenti[i].imeStudenta.substring(1).toLowerCase() + " "
                                                    + nizStudenti[i].prezimeStudenta.substring(0, 1).toUpperCase()
                                                    + nizStudenti[i].prezimeStudenta.substring(1).toLowerCase()
                                                    + " je prvobitno dobio ocenu " + nizStudenti[i].ocenaStudenta
                                                    + ", iz predmeta " + nizStudenti[i].nazivPredmeta + ".");
                                            System.out.println("\t Napredovao je, pa stoga i sada dobio novu ocenu: "
                                                    + ocena + ". Nova ocena " + ocena + " je upisana.");
                                            nizStudenti[i].ocenaStudenta = ocena;
                                            ocenaResena = true;
                                        }

                                    } else {
                                        ocenaResena = true;
                                        System.out.println(
                                                "\t Student " + nizStudenti[i].imeStudenta.substring(0, 1).toUpperCase()
                                                + nizStudenti[i].imeStudenta.substring(1).toLowerCase() + " "
                                                + nizStudenti[i].prezimeStudenta.substring(0, 1).toUpperCase()
                                                + nizStudenti[i].prezimeStudenta.substring(1).toLowerCase()
                                                + " je tada dobio ocenu " + nizStudenti[i].ocenaStudenta
                                                + ", iz predmeta " + nizStudenti[i].nazivPredmeta + ".");
                                        System.out.println(
                                                "\t Nova ocena mora biti veca od prethodne da bi je upisali u sistem! Nova ocena "
                                                + ocena + " nije upisana.");
                                    }
                                }

                            }

                        }

                    }

                    if (postojiOsoba == false) {
                        System.out
                                .println(" = = \nU nasem sistemu nije prepoznata trazena sifra predmeta i/ili student. ");
                    }

                    if ((postojiOsoba == true) && (ocenaResena == false)) {
                        System.out.println(
                                " = = \nU nizu postoji student sa tim brojem indeksa, kao i ta sifra predmeta, ali se broj indeksa ne poklapa sa sifrom predmeta koji je on polagao!");
                        break;
                    }

                } else {
                    System.out.println("\t Greska! Uneta ocena je: " + ocena);
                }
                System.out.println("----------------");
            } catch (InputMismatchException e) {
                System.out.println("\t Uneli ste karakter. Ocena mora biti broj!");
            }

        }

    }

    public static void izmenaPodatakaOStudentu() {

        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __");

        System.out.println("Ovde imate opciju da prijavite novi predmet za izabranog studenta.");
        System.out.print("Prvo unesite redni broj studenta za koga zelite da prijavite novi predmet: ");
        try {
            Scanner in = new Scanner(System.in);
            int redniBrojStudenta = in.nextInt();

            for (int i = 0; i < nizStudenti.length;) {

                if ((redniBrojStudenta - 1 < nizStudenti.length) && (redniBrojStudenta > 0)) {

                    System.out.print(
                            "Sada unesite novi naziv predmeta (napomena: novi naziv predmeta za istog studenta ne sme imati isto ime kao vec postojeci naziv): ");

                    Scanner in2 = new Scanner(System.in);

                    String noviNazivPredmeta;

                    noviNazivPredmeta = in2.next();		// nextLine = StringIndexOutOfBoundsException ( begin 0, end 1, length 0 )

                    i = redniBrojStudenta - 1;

                    if (nizStudenti[i].getSifraPredmeta().equalsIgnoreCase(noviNazivPredmeta)) {
                        System.out.println("\t " + redniBrojStudenta + ". student sa imenom: "
                                + nizStudenti[i].imeStudenta.substring(0, 1).toUpperCase()
                                + nizStudenti[i].imeStudenta.substring(1).toLowerCase() + " "
                                + nizStudenti[i].prezimeStudenta.substring(0, 1).toUpperCase()
                                + nizStudenti[i].prezimeStudenta.substring(1).toLowerCase()
                                + " vec ima predmet sa tim imenom: \""
                                + nizStudenti[i].nazivPredmeta.substring(0, 1).toUpperCase()
                                + nizStudenti[i].nazivPredmeta.substring(1).toLowerCase() + "\". Predmet nije ubacen.");
                        break;
                    } else {
                        nizStudenti[i].setSifraPredmeta(noviNazivPredmeta.substring(0, 1).toUpperCase()
                                + noviNazivPredmeta.substring(1).toLowerCase());
                        System.out.println("\t " + redniBrojStudenta + ". student sa imenom: "
                                + nizStudenti[i].imeStudenta.substring(0, 1).toUpperCase()
                                + nizStudenti[i].imeStudenta.substring(1).toLowerCase() + " "
                                + nizStudenti[i].prezimeStudenta.substring(0, 1).toUpperCase()
                                + nizStudenti[i].prezimeStudenta.substring(1).toLowerCase()
                                + " sada ima u sistemu novi naziv predmeta: \""
                                + noviNazivPredmeta.substring(0, 1).toUpperCase()
                                + noviNazivPredmeta.substring(1).toLowerCase() + "\".");

                        System.out.println(
                                "\t VAZNO: samim tim sto se promenili naziv predmeta tj. predmet koji student zeli da polaze (a koji logicno nije jos polozen), ocenu za ovaj predmet cemo postaviti na pocetnu vrednost 5.");

                        nizStudenti[i].setOcenaStudenta(5);

                        break;
                    }

                }

                if (redniBrojStudenta == 0) {
                    System.out
                            .println("\t Nula kao redni broj studenta u nizu? Pa ne postoji naravno...Pokusajte opet.");
                    break;
                }
                if (redniBrojStudenta < 0) {
                    System.out.println("\t Negativan redni broj studenta u nizu? Hmm zanimljivo...Pokusajte opet.");
                    break;
                } else {
                    System.out.println("\t Greska. Ne postoji student sa rednim brojem " + redniBrojStudenta
                            + ". Da podsetimo da trenutno u nizu imamo " + nizStudenti.length + " studenta.");
                }
                break;
            }
        } catch (InputMismatchException e) {
            System.out.println("\t Uneli ste karakter, a dozvoljeno je uneti samo redni broj.");
        }

    }

}
