package main;

public class IspitajGreske extends PrihvatiUlaz {		// nasledjuje PrihvatiUlaz jer time onda racuna ukupan broj gresaka

    public static void brojGresaka() {

        brojacGresaka++;

        if (brojacGresaka <= 1) {
            System.out.println("Broj gresaka trenutno je: " + brojacGresaka
                    + " -> (mali podsetnik: imate pravo na 2 greske ukupno pre no se program zavrsi).");
            System.out.println("-----");
        } else {
            System.out.println("Broj gresaka trenutno je: " + brojacGresaka);
            System.out.println("Drugi put greska, kraj programa! Sve najbolje!");
            System.exit(brojacGresaka);
        }

    }

}
