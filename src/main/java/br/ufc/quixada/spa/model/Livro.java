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

	/*{
	    "id": 2,
	    "foto": null,
	    "titulo": "livro1",
	    "sinopse": "dcsd",
	    "numeroPaginas": "12",
	    "autores": [],
	    "generos": []
	  }
	*/
	
	//{"foto":null,"titulo":"anderson","sinopse":"dfsdf","numeroPaginas":"122","usuario":[{"id":1 }],"autores":[],"generos":[]}
//{"titulo":"anderson","sinopse":"dfsdf","numeroPaginas":"122","usuario":[],"autores":[],"generos":[]}
	 //{"titulo":"dsfsf","sinopse":"sadsf","numeroPaginas":"12", "usuario":{"id":"1"}}
	// {"nome":"sdhaiusd", "usuario":{"id":"1"}}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Byte[] foto;

	@Column(name = "nome", nullable = false)
	private String titulo;

	@Column(name = "sinopse", nullable = false)
	private String sinopse;

	@Column(name = "num_paginas")
	private String numeroPaginas;

	@ManyToOne 
	private Usuario usuario;

	@Column(name = "genero", nullable = false)
	private String genero;
	

	@Column(name = "autor", nullable = false)
	private String autor;
/*	
	@ManyToMany
	@JoinTable(name = "livro_autor", joinColumns = { @JoinColumn(name = "autor_id") }, inverseJoinColumns = {
			@JoinColumn(name = "livro_id") })
	private List<Autor> autores;
	
	@ManyToMany
	@JoinTable(name = "livro_genero", joinColumns = { @JoinColumn(name = "genero_id") }, inverseJoinColumns = {
			@JoinColumn(name = "livro_id") })
	private List<Genero> generos;
*/
	
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

	public String getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(String numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

/*
	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}*/

	public Byte[] getFoto() {
		return foto;
	}

	public void setFoto(Byte[] foto) {
		this.foto = foto;
	}

	public Usuario getUsuario() {
		return usuario;
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
		return "Livro [id=" + id + ", foto=" + Arrays.toString(foto) + ", titulo=" + titulo + ", sinopse=" + sinopse
				+ ", numeroPaginas=" + numeroPaginas + ", usuario=" + usuario + ", genero=" + genero + ", autor="
				+ autor + "]";
	}

/*	@Override
	public String toString() {
		return "Livro [id=" + id + ", foto=" + Arrays.toString(foto) + ", titulo=" + titulo + ", sinopse=" + sinopse
				+ ", numeroPaginas=" + numeroPaginas + ", usuario=" + usuario + ", autores=" + autores + ", generos="
				+ generos + "]";
	}*/
	
	
	
	

}
