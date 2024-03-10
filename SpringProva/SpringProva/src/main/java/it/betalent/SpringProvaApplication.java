package it.betalent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProvaApplication {
	
	/*
	 * Integrare una pagina di registrazione e una pagina di login. Il login compare come prima pagina,
	 * se l'utente è registrato con username e password accederà alla tabella dove si possono eseguire le CRUD, 
	 * altrimenti potrà registrarsi con una form apposita. Servirà certamente una nuova entità Utente,
	 * un controller e un repository relativi ad essa e una nuova tabllea utenti sul database.
	 * 
	 * Attenzione alla nomenclatura! Le classi al singolare, le tabelle al plurale, ogni tabella avrà la colonna id
	 * che si chiama semplicemente "id", se volete usare per esempio "id_utente" ricordatevi che va mappato come
	 * "idUtente" nella classe!
	 */

	public static void main(String[] args) {
		SpringApplication.run(SpringProvaApplication.class, args);
	}

}
