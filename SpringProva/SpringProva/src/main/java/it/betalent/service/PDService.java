package it.betalent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.betalent.entity.Played;
import it.betalent.repository.PDRepo;

@Service
@Transactional
public class PDService {
	
	@Autowired
	private PDRepo pdRepo;
	
	public List<Played>listAll(){
		List<Played>lista = pdRepo.findAll();
		return lista;
	}
	
	public Played get(int id) {
		return pdRepo.findById(id).get();
	}
	
	public void save(Played pd) {
		pdRepo.save(pd);
	}

	public void delete(int id) {
		pdRepo.deleteById(id);
	}
	
	public List<Played> findByName(String nome) {
	    return pdRepo.findPlayedByNome(nome);
	}

}
