package adressbuch;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.SQLOutput;

/**
 * Eine textuelle Schnittstelle fuer ein Adressbuch.
 * ueber verschiedene Befehle kann auf das Adressbuch
 * zugegriffen werden.
 *
 * @author David J. Barnes und Michael K�lling.
 * @version 2008.03.30
 */
public class AdressbuchTexteingabe {
    // Das Adressbuch, das angezeigt und manipuliert werden soll.
    private Adressbuch buch;
    // Ein Parser fuer die Befehlswoerter.
    private Parser parser;

    /**
     * Konstruktor fuer Objekte der Klasse AdressbuchTexteingabe.
     *
     * @param buch das Adressbuch, das manipuliert werden soll.
     */
    public AdressbuchTexteingabe(Adressbuch buch) {
        this.buch = buch;
        parser = new Parser();
    }

    /**
     * Lies interaktiv Befehle vom Benutzer, die
     * Interaktionen mit dem Adressbuch ermoeglichen.
     * Stoppe, wenn der Benutzer 'ende' eingibt.
     */
    public void starten() {
        System.out.println(" -- Adressbuch --");
        System.out.println("Tippen Sie 'hilfe' fuer eine Liste der Befehle.");

        String command = "";

        while (!(command.equals("ende"))) {
            command = parser.liefereBefehl();
            if (command.equals("neu")) {
                neuerEintrag();
            } else if (command.equals("liste")) {
                list();
            } else if (command.equals("suche")) {
                sucheEintrag();
            } else if (command.equals("hilfe")) {
                hilfe();
            } else if (command.equals("hole")) {
                holeEintrag();
            } else if (command.equals("entferne")) {
                entferneEintrag();
            } else if (command.equals("update")) {
                aendereEintrag();
            } else {
                // nichts tun.
            }
        }

        System.out.println("Ade.");
    }

    /**
     * Fügt die eingegebenen Daten zu einem neuen Kontakt zusammen
     *
     * @return Kontakt
     */
    private Kontakt kontaktEinlesen() {

        System.out.print("Name: ");
        String name = parser.zeileEinlesen();
        System.out.print("Telefon: ");
        String telefon = parser.zeileEinlesen();
        System.out.print("Email: ");
        String adresse = parser.zeileEinlesen();
        return new Kontakt(name, telefon, adresse);
    }

    /**
     * Fuege einen neuen Eintrag hinzu.
     */


    private void neuerEintrag() {
        try {
            buch.addKontakt(kontaktEinlesen());
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
            neuerEintrag();
        }

    }

    /**
     * Finde Eintraege mit passendem Praefix.
     */
    private void sucheEintrag() {
        System.out.println("Praefix des Suchschluessels:");
        String praefix = parser.zeileEinlesen();
        Kontakt[] ergebnisse = buch.getKontakte(praefix);
        for (int i = 0; i < ergebnisse.length; i++) {
            System.out.println(ergebnisse[i]);
            System.out.println("=====");
        }
    }

    /**
     * Findet genau einen Kontakt, der zu dem eingegeben Schlüssel passt
     */
    private void holeEintrag() {
        System.out.println("Suchschluessel eingeben:");
        String schluessel = parser.zeileEinlesen();
        Kontakt ergebnis = buch.getKontakt(schluessel);
        System.out.println(ergebnis);
    }

    /**
     * Entfernt genau einen Eintrag, der zu dem eingegeben Schlüssel passt
     */
    private void entferneEintrag() {
        System.out.println("Suchschluessel eingeben:");
        String schluessel = parser.zeileEinlesen();
        buch.deleteKontakt(schluessel);
        System.out.println(schluessel + " gelöscht");

    }

    /**
     * Aendert den Eintrag, der zu dem eingegeben Schluessel passt
     */
    private void aendereEintrag() {
        try {
            System.out.println("Suchschluessel eingeben:");
            String schluessel = parser.zeileEinlesen();
            System.out.println("Neue Daten eingeben:");
            Kontakt geaendertetKontakt = kontaktEinlesen();
            buch.updateKontakt(schluessel, geaendertetKontakt);
            System.out.println(geaendertetKontakt.getName() + " geupdatet");
        }
        catch (IllegalStateException ille) {
            System.err.println(ille.getMessage());
        }
    }

    /**
     * Zeige die zur Verfuegung stehenden Befehle.
     */
    private void hilfe() {
        parser.zeigeBefehle();
    }

    /**
     * Gib den Inhalt des Adressbuchs aus.
     */
    private void list() {
        System.out.println(buch.getAlleAlsText());
    }
}
