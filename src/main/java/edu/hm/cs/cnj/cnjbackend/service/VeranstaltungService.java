package edu.hm.cs.cnj.cnjbackend.service;

import edu.hm.cs.cnj.cnjbackend.persistence.TeilnahmeStatus;
import edu.hm.cs.cnj.cnjbackend.persistence.Veranstaltung;
import edu.hm.cs.cnj.cnjbackend.persistence.VeranstaltungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class VeranstaltungService {
    @Autowired
    private VeranstaltungRepository repository;

    public void sageOffeneTeilnahmenAbBis(Date date) {
        List<Veranstaltung> veranstaltungen = repository.findByBeginnBefore(date);
        for (Veranstaltung v : veranstaltungen) {
            v.getEinladungen().forEach(i -> i.setStatus(TeilnahmeStatus.ABSAGE));
        }
    }

    @Autowired
    private VeranstaltungMapper mapper;

    public VeranstaltungDto erzeugeVeranstaltung(VeranstaltungDto veranstaltungDto) {
        Veranstaltung veranstaltung = mapper.createEntity(veranstaltungDto);
        // Vor dem Speichern sollte die fachliche Pruefung stattfinden!
        repository.save(veranstaltung);
        return mapper.createDto(veranstaltung);
    }

    public VeranstaltungDto findeVeranstaltung(long id) {
        return mapper.createDto(repository.findOne(id));
    }

    public VeranstaltungDto aktualisiere(VeranstaltungDto veranstaltungDto) {
        Veranstaltung veranstaltung = repository.findOne(veranstaltungDto.getId());
        mapper.map(veranstaltungDto, veranstaltung);
        return mapper.createDto(veranstaltung);
    }

    public void loescheVeranstaltung(Long id) {
        repository.delete(id);
    }

    public Collection<VeranstaltungDto> findeVeranstaltungen(boolean
                                                                     vergangeneEventsAnzeigen) {
        if (vergangeneEventsAnzeigen) {
            return mapper.createDtoList(repository.findAll());
        } else {
            return mapper.createDtoList(repository.findByBeginnAfter(new Date()));
        }
    }
}
