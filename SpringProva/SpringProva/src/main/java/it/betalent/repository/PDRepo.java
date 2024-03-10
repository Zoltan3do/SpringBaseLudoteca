package it.betalent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.betalent.entity.Played;

@Repository
public interface PDRepo extends JpaRepository<Played,Integer> {

	//possibilità di implementare i query methods
	//https://docs.spring.io/spring-data/jpa/current/reference/html/ (cap 4)

	List<Played> findPlayedByNome(String nome);

}
