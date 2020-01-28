package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrihvatiUlaz extends Main { // da bih dole mogao napisati return opcija = PrihvatiUlaz.prihvatiBroj();

    static int brojacGresaka;

    public static int prihvatiBroj() {
        System.out.println("****************   ****************   ****************   ****************   ****************");
        System.out.print("0. Prekini program" + "\n");
        System.out.print("1. Pregled svih predmeta" + "\n");
        System.out.print("2. Pregled svih studenata" + "\n");
        System.out.print("3. Pregled svih prijava za trazenog studenta" + "\n");
        System.out.print("4. Prikaz studenata koji su polozili odredjeni predmet" + "\n");
        System.out.print("5. Unos nove prijave (ocene)" + "\n");
        System.out.print("6. Izmena podatka o studentu" + "\n");
        System.out.println("****************   ****************   ****************   ****************   ****************");
        System.out.print(" \r Unesi broj opcije (0-6): " + " ");

        try {
            Scanner in = new Scanner(System.in); // import java.util.Scanner;
            return in.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Uneli ste karakter. Pun opis greske je: " + e);
            brojacGresaka++;

            if (brojacGresaka <= 1) {
                System.out.println("Broj gresaka trenutno je: " + brojacGresaka
                        + " -> (mali podsetnik: imate pravo na 2 greske ukupno pre no se program zavrsi).");
                System.out.println("-----");
            } else {
                System.out.println("Broj gresaka trenutno je: " + brojacGresaka);
                System.out.println("Drugi put greska, kraj programa! Sve najbolje!");
                System.exit(0);
            }

        }
        return opcija = PrihvatiUlaz.prihvatiBroj();

    }

    public static int ispitajKraj() {

        System.out.println("__ __ __ __ __ __ __ __ __ __ __ __ __ __ __");

        System.out.print(
                "Stvarno prekini sa ovim programom pripremljenim sa jako puno paznje ^(napomena: mozete samo uneti \"da\" ili \"ne\"): ");

        Scanner in = new Scanner(System.in);
        String unetaRec = "";
        String korisnikZeliDaPrekine = "da";
        String korisnikZeliDaNastavi = "ne";

        //int korisnikSamovoljnoOtisao = 9988;
        while (!unetaRec.equalsIgnoreCase(korisnikZeliDaPrekine)) {

            unetaRec = in.nextLine();

            if (unetaRec.equalsIgnoreCase(korisnikZeliDaNastavi)) {
                System.out.println("Hvala sto nastavljate dalje sa programom!");
                return 1;
            } else if (!unetaRec.equalsIgnoreCase(korisnikZeliDaPrekine)) {

                if (unetaRec.strip().equals("")) {
                    System.out.println("\t Pa nemojte prazni karakter zaboga...  ajmo polako opet: ");
                }
                if ((!unetaRec.strip().equals("")) && (!unetaRec.matches("-?\\d+(\\.\\d+)?"))) {
                    System.out.print("\t Uneli ste: " + "\"" + unetaRec.strip() + "\"" + ", pokusajte opet: ");
                }
                if (unetaRec.matches("-?\\d+(\\.\\d+)?")) {
                    System.out.println("\t Nema unosa broja: \"" + unetaRec
                            + "\", molim Vas ne pokusajte da me prevarite tako podlo :D !");
                    System.out.print("Unesi opet(\"da\" ili \"ne\"): ");
                }

            }
        }
        System.out.print("Molim za jos jednu sitnicu \n-> Vasa generalna ocena ovog programa je: ");

        Scanner inOcena = new Scanner(System.in);
        try {
            int prihvatiOcenuBroj = inOcena.nextInt();

            while ((prihvatiOcenuBroj > 10) || (prihvatiOcenuBroj < 5)) {

                System.out.print("\t uneli ste ocenu: " + prihvatiOcenuBroj + ", ocena mora biti izmedju 5 i 10. Pokusajte ponovo: ");
                prihvatiOcenuBroj = inOcena.nextInt();
            }

            System.out.println("Sacekajte tacno 5 sekundi, obrada ocene u toku...");
            System.out.println("-----------------");
            Thread.sleep(5000);

            if (prihvatiOcenuBroj == 10) {
                System.out.println("\t Zahvaljujem na takvoj oceni! Prijatan dan. \nP.S. proverite svakako fajl koji se upravo generisao (uradite \"refresh\" levog panela programa koji koristite). :)");
            }
            if (prihvatiOcenuBroj == 9) {
                System.out.println("\t Hmm...pa mogla je ocena biti i 10, ali ajde... Prijatan dan. \nP.S. proverite takodje i fajl koji se upravo generisao (uradite \"refresh\" levog panela programa koji koristite). :)");
            }
            if (prihvatiOcenuBroj < 9) {
                System.out.println("\t Nisam zadovoljan tom ocenom, ali hvala svakako. Prijatan dan. \nP.S. proverite takodje i fajl koji se upravo generisao (uradite \"refresh\" levog panela programa koji koristite). :)");
            }

            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("Ocena_Izvestaj.xls"))));

            out.println("Ime: Luka");
            out.println("Prezime: Djekovic");
            out.println("Ocena: " + prihvatiOcenuBroj);
            out.checkError();
            out.close();

        } catch (InputMismatchException | IOException | InterruptedException e) {
            System.out.println("Uneli ste karakter, a to nije dozvoljeno!");
            return opcija = ispitajKraj();
        }
        System.exit(0);
        return 1;

    }

}
