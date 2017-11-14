package edu.hm.cs.cnj.cnjbackend.persistence;

import org.hibernate.validator.constraints.Length;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Veranstaltung {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 140, unique = true)
    @Length(min = 8)
    @NotNull
    private String titel;

    @Column(length = 1000)
    @NotNull
    private String beschreibung;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date beginn;

    @OneToMany(mappedBy = "veranstaltung", cascade = CascadeType.ALL)
    private Set<Teilnahme> einladungen = new HashSet<>();

    public Set<Teilnahme> getEinladungen() {
        return einladungen;
    }

    public void add(Teilnahme teilnahme) {
        einladungen.add(teilnahme);
        teilnahme.setVeranstaltung(this);
    }

    public Veranstaltung(String titel, String beschreibung, Date beginn) {
        super();
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.beginn = beginn;
    }

    public Veranstaltung() {
        // JPA benoetigt Default-Konstruktor
    }

    public Long getId() {
        return id;
    }
}
