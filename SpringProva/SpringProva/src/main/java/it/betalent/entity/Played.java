package it.betalent.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="played")
public class Played {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name= "voto")
	private int voto;
	
	@Column(name="anno")
	private int anno;
	
	public Played() {}
	public Played(String nome, int voto, int anno) {
		super();
		this.nome = nome;
		this.voto = voto;
		this.anno = anno;
	}

	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}


	@Override
	public String toString() {
		return "id=" + id + ", nome=" + nome + ", voto=" + voto + ", anno=" + anno;
	}

}
