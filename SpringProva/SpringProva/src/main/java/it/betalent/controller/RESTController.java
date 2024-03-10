package it.betalent.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.betalent.entity.Played;
import it.betalent.repository.PDRepo;

@RestController
public class RESTController {

	@Autowired
	private PDRepo pdRepo;

	@GetMapping("/giochi")
	List<Played>findAll(){
		return pdRepo.findAll();
	}

	/*@GetMapping("/games")
	CollectionModel<EntityModel<Played>> all(){

		List<Played> giochi =pdRepo.findAll();
		ArrayList<EntityModel<Played>> giochiMappati = new ArrayList<EntityModel<Played>>();

		for (Played p:giochi) {
			EntityModel<Played> eventoMappato = new EntityModel<>(p,
					LinkTo(methodOn(RESTController.class).findOne(p.getId())).withSelfRel(),
					LinkTo(methodOn(RESTController.class).findAll()).withRel("ciao"));
			giochiMappati.add(eventoMappato);
		}
		
		return new CollectionModel<>(giochiMappati,
				LinkTo(methodOn(RESTController.class).findAll()).withSelfRel());
	}
	
	@GetMapping("/games/{id}")
	EntityModel<Played> findOne(@PathVariable int id){
		
		Optional<Played> giocoDaTrovare = pdRepo.findById(id);
		Played giocoCorrente = null;
	
		if(giocoDaTrovare.isPresent()) giocoCorrente = giocoDaTrovare.get();
		
		return new EntityModel<Played>(giocoCorrente,
				)
			
	}*/

	@PostMapping(value="/giochi", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	void nuovoGioco(@RequestBody Played nuovoGioco) {
		System.out.println(pdRepo.save(nuovoGioco).toString());
	}

	@PutMapping("/giochi/{id}")
	void modifica(@RequestBody Played modificaGioco, @PathVariable int id) {
		Optional<Played>daModificare = pdRepo.findById(id);
		if(daModificare.isPresent()) {
			Played currentPl = daModificare.get();
			currentPl.setNome(modificaGioco.getNome());
			currentPl.setVoto(modificaGioco.getVoto());
			currentPl.setAnno(modificaGioco.getAnno());
			System.out.println(pdRepo.save(currentPl).toString());
		}else {
			System.out.println("Mi Spiace");
		}
	}

	@DeleteMapping("/giochi/{id}")
	void cancellaGioco(@PathVariable int id) {
		pdRepo.deleteById(id);
	}

}