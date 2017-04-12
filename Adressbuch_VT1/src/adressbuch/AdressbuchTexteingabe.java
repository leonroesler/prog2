package adressbuch;

/**
 * Eine textuelle Schnittstelle fuer ein Adressbuch.
 * ueber verschiedene Befehle kann auf das Adressbuch
 * zugegriffen werden.
 *
 * @author David J. Barnes und Michael K�lling.
 * @version 2008.03.30
 */
public class AdressbuchTexteingabe
{
    // Das Adressbuch, das angezeigt und manipuliert werden soll.
    private Adressbuch buch;
    // Ein Parser fuer die Befehlswoerter.
    private Parser parser;
    
    /**
     * Konstruktor fuer Objekte der Klasse AdressbuchTexteingabe.
     * @param buch das Adressbuch, das manipuliert werden soll.
     */
    public AdressbuchTexteingabe(Adressbuch buch)
    {
        this.buch = buch;
        parser = new Parser();
    }
    
    /**
     * Lies interaktiv Befehle vom Benutzer, die 
     * Interaktionen mit dem Adressbuch ermoeglichen.
     * Stoppe, wenn der Benutzer 'ende' eingibt.
     */
    public void starten()
    {
        System.out.println(" -- Adressbuch --");
        System.out.println("Tippen Sie 'hilfe' fuer eine Liste der Befehle.");
        
        String command = "";
        
        while(!(command.equals("ende"))) {
            command = parser.liefereBefehl();
            if(command.equals("neu")){ 
                neuerEintrag();
            }
            else if(command.equals("liste")){
                list();
            }
            else if(command.equals("suche")){
                sucheEintrag();
            }
            else if(command.equals("hilfe")){
                hilfe();
            }
            else{
                // nichts tun.
            }
        } 

        System.out.println("Ade.");
    }
    
    /**
     * Fuege einen neuen Eintrag hinzu.
     */
    private void neuerEintrag()
    {
        System.out.print("Name: ");
        String name = parser.zeileEinlesen();
        System.out.print("Telefon: ");
        String telefon = parser.zeileEinlesen();
        System.out.print("Email: ");
        String adresse = parser.zeileEinlesen();
        buch.addKontakt(new Kontakt(name, telefon, adresse));
    }
    
    /**
     * Finde Eintraege mit passendem Praefix.
     */
    private void sucheEintrag()
    {
        System.out.println("Praefix des Suchschluessels:");
        String praefix = parser.zeileEinlesen();
        Kontakt[] ergebnisse = buch.getKontakte(praefix);
        for(int i = 0; i < ergebnisse.length; i++){
            System.out.println(ergebnisse[i]);
            System.out.println("=====");
        }
    }

    private void holeEintrag() {
        System.out.println("Praefix des Suchschluessels:");
        String praefix = parser.zeileEinlesen();
        Kontakt[] ergebnisse = buch.getKontakte(praefix);
        for(int i = 0; i < ergebnisse.length; i++){
            System.out.println(ergebnisse[i]);
            System.out.println("=====");
        }
    }
    
    /**
     * Zeige die zur Verfuegung stehenden Befehle.
     */
    private void hilfe()
    {
        parser.zeigeBefehle();
    }
    
    /**
     * Gib den Inhalt des Adressbuchs aus.
     */
    private void list()
    {
        System.out.println(buch.getAlleAlsText());
    }
}
