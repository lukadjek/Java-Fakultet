SPECIFIKACIJA

Kratak opis: Program koji omogucava rad sa studentima i predmetima uz par zanimljivih opcija. 
Programom upravlja korisnik preko tastature.

	1.	Program se sastoji iz glavnog menija koji obuhvata sledece opcije:
	⁃	0. Prekini program
	⁃	1. Pregled svih predmeta
	⁃	2. Pregled svih studenata
	⁃	3. Pregled svih prijava za trazenog studenta
	⁃	4. Prikaz studenata koji su polozili odredjeni predmet
	⁃	5. Unos nove prijave (ocene)
	⁃	6. Izmena podataka o studentu
  
2.	Objasnjenje opcija:

	a) 0. Prekini program - izborom ove opcije mora se korisnik jos jednom pitati da li je siguran da zeli da prekine sa programom (moze uneti samo «DA» ili «NE»). 
  Ako izabere opciju «NE», program ga vraca nazad u glavni meni i zahvaljuje na daljem nastavljanju. 
  Ako izabere opciju «DA», program ga mora pitati za ocenu koja mora biti u rangu 5-10 i onda u skladu sa datom ocenom (nakon cekanja od 5 sekundi) daje komentar uz kreiranje izvestaja koji sadrzi ime i prezime osobe koja je napravila program i kao ocenu koju je korisnik dao.
	
    b) 1. Pregled svih studenata - izborom ove opcije prikazuju se 			predmeti tj. tabela koja sadrzi redni broj predmeta, sifru predmeta i 		naziv predmeta (predefinisani u programu)
	
    c) 2. Pregled svih studenata - izborom ove opcije se prikazuju 			studenti tj. tabela koja sadrzi redni broj predmeta, broj indeksa, 			godina upisa, ime, prezime, naziv predmeta, ocena, danasnji datum 		(predefinisani u programu);
	
    d) 3. Pregled svih prijava za trazenog studenta - izborom ove opcije 		sistem mora da pita korisnika da unese broj indeksa. Ukoliko je isti 		ispravan tj. vec postoji u sistemu, onda se prikazuje ime i prezime 		studenta sa tim brojem indeksa kao i njegov/njen prijavljen ispit. 			Ukoliko uneseni broj indeksa ne postoji onda se mora korisniku 			ukazati na to da trazeni indeks nije pronadjen kao i info. poruka kao 		podsetnik gde on sam moze imati uvid brojeve indeksa studenta;
	
    e) 4. Prikaz studenata koji su polozili odredjeni predmet - izborom 		ove 	opcije sistem mora da pita korisnika da unese sifru predmeta. U		 slucaju da ta sifra postoji, onda sistem mora korisniku jasno prikazati 		da je ta sifra nadjena, ime i prezime studenta, predmet koji je on/ona 		prijavio/prijavila i na kraju info. poruku da li je on/ona polozio/polozila 		dati ispit uz prikaz ocene na ispitu. U slucaju da je sifra pogresna, 		onda se korisniku to mora jasno dati do znanja uz podsetnik gde on 		sam moze imati uvid u sifre predmeta;
	
    f) 5. Unos nove prijave (ocene) - izborom ove opcije korisnik ima 		opciju da unese novu ocenu studenta samo za predmet koji je on/ona 	prvobitno polagao/polagala. On ovde mora da unese: sifru predmeta, 		broj indeksa, datum u formatu dd-MM-yyyy, ocenu u rangu 5-10. 		Svaki od ovih kriterijuma mora biti ispunjen u celosti. Nakon toga se 		vrsi provera da li student i sifra predmeta postoje u sistemu, kao i da 		li je nova ocena studenta sada veca od prethodne za taj predmet sa 		tom sifrom. Ukoliko postoji i ukoliko je nova ocena veca od 				prethodne, onda se tom studentu za predmet sa tom sifrom 			pise nova ocena. Ukoliko postoji i ukoliko je nova ocena manja od 		prethodne onda se ista ne upisuje. Ukoliko postoji ali ako se student 		ne poklapa sa sifrom predmeta (student nije polagao taj predmet) 		onda se ocena ne upisuje. Ukoliko nema sifre i/ili studenta onda se 		ocena ne upisuje. Za svaki scenarijo se 	mora prikazati odgovarajuca 		poruka.
	
    g) 6. Izmena podatka o studentu - izborom ove opcije pruza se 			korisniku mogucnost da prijavi novi predmet za izabranog studenta. 		Obavezan je unos sledecih podataka: redni broj studenta za koga 		treba da se prijavi novi predmet, novi naziv predmeta (koji ne moze 		imati isti naziv kao vec postojeci naziv). Ukoliko se unese novi naziv 		onda se ta promena belezi u sistemu i studentu se daje ocena 5 dok 		ga ne polozii. Ukoliko se unese vec postojeci naziv, onda se isti ne 		ubacuje u sistem.

3. Napomene: korisnik ima pravo na 1 gresku prilikom kretanja kroz glavni meni (opcija mora da bude izmedju 0-6 i unos karaktera je zabranjen). U slucaju da napravi i drugu gresku onda se program mora prekinuti.


