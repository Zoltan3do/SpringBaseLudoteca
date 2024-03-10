package it.betalent.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import it.betalent.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User,Integer>{

	User findUserByUsernameAndPassword(String username,String password);
	List<User>findUserByUsername(String username);
}