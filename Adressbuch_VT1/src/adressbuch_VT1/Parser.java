package adressbuch_VT1;import java.util.Scanner;/** * Eine Klasse, die Eingaben vom Benutzer entgegen nimmt. * Die Eingaben werden in 'liefereBefehl' nach gueltigen * Befehlen gefiltert. * * @author  Michael K�lling und David J. Barnes * @version 2008.03.30 */public class Parser {    // Die gueltigen Befehlswoerter.    private adressbuch_VT2.Befehlswoerter befehlswoerter;    private Scanner scanner;    public Parser()     {        befehlswoerter = new adressbuch_VT2.Befehlswoerter();        // hier wird eine Instanz von Scanner erzeugt, die von der Konsole einliest.        scanner = new Scanner(System.in);    }    /**     * Lies den naechsten Benutzerbefehl ein.     * Der gelieferte Befehl ist gueltig.     * @return ein gueltiger Befehl.     */    public String liefereBefehl()     {        String befehl = null;        while(befehl == null) {            // Eingabeaufforderung ausgeben            System.out.print("> ");            // Naechstes Token (Wort) einlesen            String wort = scanner.next();            // Den Rest der Zeile verwerfen.            zeileEinlesen();            if(befehlswoerter.istBefehl(wort)) {                befehl = wort;            }            else{                System.out.println("Unbekannter Befehl: " + wort);                System.out.print("Gueltige Befehle sind: ");                befehlswoerter.alleAusgeben();            }        }             return befehl;    }        /**     * Gib eine Liste der gueltigen Befehlsw�rter     * auf der Konsole aus.     */    public void zeigeBefehle()    {        befehlswoerter.alleAusgeben();    }    /**     * @return eine Zeile Text vom Benutzer.     */    public String zeileEinlesen()    {        return scanner.nextLine();    }}