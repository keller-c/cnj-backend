package edu.hm.cs.cnj.cnjbackend.service;

import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import edu.hm.cs.cnj.cnjbackend.persistence.Veranstaltung;
import edu.hm.cs.cnj.cnjbackend.persistence.VeranstaltungRepository;

@Service
@Transactional
public class VeranstaltungService {

	public static final Logger LOG = LoggerFactory.getLogger(VeranstaltungService.class);
	
	@Autowired
	private VeranstaltungRepository repository;
	
	@Autowired
	private VeranstaltungMapper mapper;

	@Autowired
	private EventGateway gateway;
	
	@CacheEvict(value="cnj-evnt", key="#veranstaltungDto.getId()")
	public VeranstaltungDto erzeugeVeranstaltung(VeranstaltungDto veranstaltungDto) {
		Veranstaltung veranstaltung = mapper.createEntity(veranstaltungDto);
			
		// Vor dem Speichern sollte die fachliche Prüfung stattfinden!		
		repository.save(veranstaltung);
				
		return mapper.createDto(veranstaltung);
	}


	@Cacheable("cnj-evnt")
	public VeranstaltungDto findeVeranstaltung(long id) {
		LOG.info("Schade! Datenbankzugriff!");
		return mapper.createDto(repository.findOne(id));
	}

	@CachePut(value = "cnj-evnt", key="#veranstaltungDto.getId()")
	public VeranstaltungDto aktualisiere(
			VeranstaltungDto veranstaltungDto) {
		Veranstaltung veranstaltung = 
				repository.findOne(veranstaltungDto.getId());
		
		gateway.changeEvent(veranstaltungDto);
		
		mapper.map(veranstaltungDto, veranstaltung);
		return mapper.createDto(veranstaltung);
	}

	@CacheEvict(value="cnj-evnt", key="#id")
	public void loescheVeranstaltung(Long id) {
		repository.delete(id);
	}

	public Collection<VeranstaltungDto> findeVeranstaltungen(boolean vergangeneEventsAnzeigen) {
		if (vergangeneEventsAnzeigen) {
			return mapper.createDtoList(repository.findAll());
		} else {
			return mapper.createDtoList(repository.findByBeginnAfter(new Date()));
		}
	}
}
