package br.ufc.quixada.spa.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	public Livro() {
	}

	public Livro(Long id) {
		this.id = id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "foto")
	private String foto;

	@Column(name = "nome", nullable = false)
	private String titulo;

	@Column(name = "sinopse", nullable = false)
	private String sinopse;

	@ManyToOne 
	private Usuario usuario;

	@Column(name = "genero", nullable = false)
	private String genero;
	
	@Column(name = "autor", nullable = false)
	private String autor;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", foto=" + foto + ", titulo=" + titulo + ", sinopse=" + sinopse + ", usuario="
				+ usuario + ", genero=" + genero + ", autor=" + autor + "]";
	}

	

	
	
	
	
	

}
