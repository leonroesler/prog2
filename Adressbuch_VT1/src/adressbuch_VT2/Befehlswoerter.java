package adressbuch_VT2;/** * Diese Klasse h�lt eine Aufzaehlung aller Befehlswoerter, * die dem Programm bekannt sind. * * @author  Michael K�lling und David J. Barnes * @version 2008.03.30 */public class Befehlswoerter{    // Ein konstantes Array mit den gueltigen Befehlswoertern    private static final String gueltigeBefehle[] = {        "neu", "suche", "liste", "hilfe", "ende", "hole", "entferne", "aendere", "checkNull"    };    /**     * Konstruktor fuer Befehlswoerter     */    public Befehlswoerter()    {    }    /**     * Pruefe, ob der gegebene String ein gueltiges Befehlswort ist.     * @param einString der zu pruefende String.     * @return true, wenn er gueltig ist, false sonst.     */    public boolean istBefehl(String einString)    {        if(einString != null){            for(int i = 0; i < gueltigeBefehle.length; i++) {                if(gueltigeBefehle[i].equals(einString))                    return true;            }        }        // Schleife komplett durchlaufen: nicht gefunden.        return false;    }    /**     * Gib alle gueltigen Befehle auf System.out aus.     */    public void alleAusgeben()     {        for(String befehl : gueltigeBefehle) {            System.out.print(befehl + "  ");        }        System.out.println();    }}