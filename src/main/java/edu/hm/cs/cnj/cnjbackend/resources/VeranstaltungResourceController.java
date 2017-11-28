package edu.hm.cs.cnj.cnjbackend.resources;

import edu.hm.cs.cnj.cnjbackend.service.VeranstaltungDto;
import edu.hm.cs.cnj.cnjbackend.service.VeranstaltungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/v1/veranstaltungen")
public class VeranstaltungResourceController {
    @Autowired
    VeranstaltungService service;

    @GetMapping
    ResponseEntity<Collection<VeranstaltungDto>> findeVeranstaltungen(
            @RequestParam(name = "allEvents", defaultValue = "false") boolean
                    vergangeneEventsAnzeigen) {
        return
                ResponseEntity.ok(service.findeVeranstaltungen(vergangeneEventsAnzeigen));
    }

    @PostMapping
    ResponseEntity<VeranstaltungDto> erzeugeVeranstaltung(@RequestBody
                                                                  VeranstaltungDto veranstaltung) {
        VeranstaltungDto created = service.erzeugeVeranstaltung(veranstaltung);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    ResponseEntity<VeranstaltungDto> findeVeranstaltung(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findeVeranstaltung(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<VeranstaltungDto> aktualisiereVeranstaltung(@PathVariable("id")
                                                                       Long id,
                                                               @RequestBody VeranstaltungDto veranstaltung) {
        // hier sollte man pruefen, dass die Id zum uebergebenen Objekt passt..
        return ResponseEntity.ok(service.aktualisiere(veranstaltung));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> loescheVeranstaltung(@PathVariable("id") Long id) {
        service.loescheVeranstaltung(id);
        return ResponseEntity.noContent().build();
    }
}
