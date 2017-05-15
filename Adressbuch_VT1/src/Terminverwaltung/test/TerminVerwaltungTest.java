package Terminverwaltung.test;


import Terminverwaltung.src.terminverwaltung.Termin;
import Terminverwaltung.src.terminverwaltung.TerminUeberschneidungException;
import org.junit.Test;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by Marlon on 15.05.2017.
 */

public class TerminVerwaltungTest {
    private TreeMap<LocalDate, ArrayList<Termin>> termineDate;
    private HashMap<String, Termin> termineId;


    @Test
    public void initialisieren() throws Exception {
    }

    @Test
    public void getTermineTag() throws Exception {
    }

    @Test
    public void addTermin(Termin t) throws Exception {
        Termin alt = checkTerminUeberschneidung(t);
        if (alt == null) {
            //addTerminDate(t);
            termineId.put(t.getId(), t);
        } else {
            throw new TerminUeberschneidungException(alt);
        }
    }

    @Test
    public void updateTermin() throws Exception {
    }

    @Test
    public void removeTermin() throws Exception {
    }

    @Test
    public Termin checkTerminUeberschneidung(Termin neu) throws Exception {
        return neu;
    }

    @Test
    public void getTermin() throws Exception {
    }

    @Test
    public void getAllTermine() throws Exception {
    }

}
