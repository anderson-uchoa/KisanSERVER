package br.ufc.quixada.spa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@ManyToMany
	@JoinTable(name = "livro_autor", joinColumns = { @JoinColumn(name = "autor_id") }, inverseJoinColumns = {
			@JoinColumn(name = "livro_id") })
	private List<Livro> livros;

	public Autor() {
		// TODO Auto-generated constructor stub
	}

}
