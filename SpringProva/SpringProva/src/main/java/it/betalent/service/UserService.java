package it.betalent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.betalent.entity.User;
import it.betalent.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public void save(User ur) {
		userRepo.save(ur);	
	}
	
	public List<User> listaUtenti(){
		return userRepo.findAll();
	}

	public User findByUsernameAndPassword(String username, String password) {
		return userRepo.findUserByUsernameAndPassword(username,password);
	}
	
	public List<User>trovaPerUsername(String username){
		return userRepo.findUserByUsername(username);
	}

}
