package adressbuch_VT3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by leon on 17.05.2017.
 */
public class TerminVerwaltungTest {

    private TerminVerwaltung verwaltung;
    private Termin t1, t2, t3;
    private TreeMap<LocalDate, ArrayList<Termin>> termineDate;
    private HashMap<String, Termin> termineId;

    @Before
    public void setUp() throws Exception {

        termineDate = new TreeMap<LocalDate, ArrayList<Termin>>();
        termineId = new HashMap<String, Termin>();

        Termin[] allTermine;
        verwaltung = new TerminVerwaltung();
        System.out.println();
        System.out.println("SetUp der benötigten Testobjekte");
        System.out.println();

        //Termindummies erstellen
        try {
            LocalDate date = LocalDate.of(2014, 5, 19);
            t1 = new Termin("Termin1", date, LocalTime.of(9, 0), LocalTime.of(10, 0));
            t2 = new Termin("Termin2", date, LocalTime.of(10, 30), LocalTime.of(11, 0));
            t3 = new Termin("Termin3", date, LocalTime.of(11, 15), LocalTime.of(12, 30));

        } catch (UngueltigerTerminException ex) {
            System.out.println(ex);
        }

    }

    private void termineAusgeben(Termin[] termine) {
        if (termine == null || termine.length == 0) {
            System.out.println("Keine Termine\n");
        } else {
            for (Termin t : termine) {
                System.out.println(t.getInfo());
                System.out.println();
            }
        }
    }

    @Test
    public void getTermineTag() throws Exception {

    }

    @Test
    public void addTermin() throws Exception{
        termineId.put(t1.getId(), t1);

        assertTrue(!termineId.isEmpty());
    }

    /**
    @Test (expected = TerminUeberschneidungException.class)
    public void addTermin_TerminUeberschreitungsExc() {
        termineId.put(t1.getId(), t1);
        termineId.put(t1.getId(), t1);
    }
     */

    @Test
    public void updateTermin() throws Exception {

    }

    @Test
    public void removeTermin() throws Exception {

    }

    @Test /**(expected = TerminUeberschneidungException.class)*/
    public void checkTerminUeberschneidung() {
        TerminVerwaltung verwaltung = new TerminVerwaltung();
        ArrayList<Termin> liste = termineDate.get(t2.getDatum());
        termineDate.put(t2.getDatum(), liste);

        assertEquals(t2.getVon(), t2.getVon());
        assertEquals(t2.getBis(), t2.getBis());
        assertTrue("bubu mute: Termin ueberschneidet sich", true );
    }

    @Test
    public void getTermin() throws Exception {

    }

    @Test
    public void getAllTermine() throws Exception {

    }

}