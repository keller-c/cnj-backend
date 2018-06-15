package edu.hm.cs.cnj.cnjbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import edu.hm.cs.cnj.cnjbackend.persistence.Veranstaltung;

@Component
public class VeranstaltungMapper {

	public Veranstaltung createEntity(VeranstaltungDto dto) {
		Veranstaltung result = new Veranstaltung();
		return map(dto, result);
	}

	public VeranstaltungDto createDto(Veranstaltung entity) {
		VeranstaltungDto result = new VeranstaltungDto();
		return map(entity, result);
	}

	public Veranstaltung map(VeranstaltungDto dto, Veranstaltung result) {
		result.setTitel(dto.getTitel());
		result.setBeschreibung(dto.getBeschreibung());
		result.setBeginn(dto.getBeginn());
		result.setId(dto.getId());
		return result;
	}

	public VeranstaltungDto map(Veranstaltung entity, VeranstaltungDto result) {
		result.setTitel(entity.getTitel());
		result.setBeschreibung(entity.getBeschreibung());
		result.setBeginn(entity.getBeginn());
		result.setId(entity.getId());
		return result;
	}

	public List<VeranstaltungDto> createDtoList(List<Veranstaltung> entities) {
		ArrayList<VeranstaltungDto> result = new ArrayList<>();
		if (entities != null) {
			for (Veranstaltung entity : entities) {
				result.add(createDto(entity));
			}
		}
		return result;
	}

}
