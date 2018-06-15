package edu.hm.cs.cnj.cnjbackend.persistence;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VeranstaltungRepository extends JpaRepository<Veranstaltung, Long> {

	List<Veranstaltung> findByBeginnBefore(Date date);

	List<Veranstaltung> findByBeginnAfter(Date date);
}

