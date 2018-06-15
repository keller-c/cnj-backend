package edu.hm.cs.cnj.cnjbackend.persistence;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

import org.hibernate.validator.constraints.Length;

@Entity
public class Veranstaltung {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length=140, unique=true)
	@Length(min=8)
	@NotNull
	private String titel; 
	
	@Column(length=1000)
	@NotNull
	private String beschreibung; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date beginn;
		
	@OneToMany(mappedBy="veranstaltung", cascade = CascadeType.ALL)
	private Set<Teilnahme> einladungen = new HashSet<>();

	public Veranstaltung() {
		// JPA benoetigt Default-Konstruktor
	}
	
	
	public Veranstaltung(String titel, String beschreibung, Date beginn) {
		super();
		this.titel = titel;
		this.beschreibung = beschreibung;
		this.beginn = beginn;
	}
		
	public void add(Teilnahme teilnahme) {
		einladungen.add(teilnahme);
		teilnahme.setVeranstaltung(this);
	}

	public Date getBeginn() {
		return beginn;
	}

	public String getBeschreibung() {		
		return beschreibung;
	}

	public Long getId() {
		return id;
	}

	public Collection<Teilnahme> getTeilnahmen() {
		return Collections.unmodifiableCollection(einladungen);
	}

	public String getTitel() {		
		return titel;
	}


	public void setBeginn(Date beginn) {
		this.beginn = beginn;		
	}


	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setTitel(String titel) {
		this.titel = titel;
	}
}

