package edu.hm.cs.cnj.cnjbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Component
public class DataInitializer {
    @Autowired
    private VeranstaltungService veranstaltungen;


    @PostConstruct
    public void erstelleDaten() {
        long v1 = veranstaltungen.erzeugeVeranstaltung(
                "100 Jahre Java",
                "Festmahl zu Ehren aller Java-Entwickler",
                new GregorianCalendar(2017, Calendar.JULY, 12, 20, 00, 00).getTime());
        veranstaltungen.fuegeTeilnahmeHinzu(v1, "Bernd das Brot", 3);
        veranstaltungen.fuegeTeilnahmeHinzu(v1, "Spongebob", 0);
        long v2 = veranstaltungen.erzeugeVeranstaltung(
                "Workshop aufrechtes Sitzen",
                "Zertifizierungsworkshop ft\u00FCr das Sitzen auf St\u00FChlen mit mindestens drei Beinen.",
                new GregorianCalendar(2018, Calendar.AUGUST, 2, 9, 30, 00).getTime());
        veranstaltungen.fuegeTeilnahmeHinzu(v2, "Thor", 0);
        veranstaltungen.fuegeTeilnahmeHinzu(v2, "Superman", 0);
        veranstaltungen.sageOffeneTeilnahmenAbBis(
                new GregorianCalendar(2017, Calendar.DECEMBER, 31, 23, 59, 59).getTime());
    }
}