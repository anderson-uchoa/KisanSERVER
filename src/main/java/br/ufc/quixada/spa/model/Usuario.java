package br.ufc.quixada.spa.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	public Usuario() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name ="id_facebook")
	private Long id_facebook;
	@Column
	private Byte[] foto;

	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "tokenGCM", nullable = false)
	private String tokenGCM;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "endereco")
	private String endereco;

	@Column(name = "cidade", nullable = false)
	private String cidade;
	

    @JsonIgnore
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "livros_desejados", joinColumns = { @JoinColumn(name = "usuario_id") }, inverseJoinColumns = {
			@JoinColumn(name = "livro_id") })
	private List<Livro> livrosDesejados;

    @JsonIgnore
	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Livro> livros;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Byte[] getFoto() {
		return foto;
	}

	public void setFoto(Byte[] foto) {
		this.foto = foto;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<Livro> getLivros() {
		return livros;
	}


	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public List<Livro> getLivrosDesejados() {
		return livrosDesejados;
	}

	public void setLivrosDesejados(List<Livro> livrosDesejados) {
		this.livrosDesejados = livrosDesejados;
	}

	public Long getId_facebook() {
		return id_facebook;
	}

	public void setId_facebook(Long id_facebook) {
		this.id_facebook = id_facebook;
	}

	public String getTokenGCM() {
		return tokenGCM;
	}

	public void setTokenGCM(String tokenGCM) {
		this.tokenGCM = tokenGCM;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + Arrays.hashCode(foto);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_facebook == null) ? 0 : id_facebook.hashCode());
		result = prime * result + ((livros == null) ? 0 : livros.hashCode());
		result = prime * result + ((livrosDesejados == null) ? 0 : livrosDesejados.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tokenGCM == null) ? 0 : tokenGCM.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (!Arrays.equals(foto, other.foto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_facebook == null) {
			if (other.id_facebook != null)
				return false;
		} else if (!id_facebook.equals(other.id_facebook))
			return false;
		if (livros == null) {
			if (other.livros != null)
				return false;
		} else if (!livros.equals(other.livros))
			return false;
		if (livrosDesejados == null) {
			if (other.livrosDesejados != null)
				return false;
		} else if (!livrosDesejados.equals(other.livrosDesejados))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tokenGCM == null) {
			if (other.tokenGCM != null)
				return false;
		} else if (!tokenGCM.equals(other.tokenGCM))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", id_facebook=" + id_facebook + ", foto=" + Arrays.toString(foto) + ", nome="
				+ nome + ", tokenGCM=" + tokenGCM + ", email=" + email + ", endereco=" + endereco + ", cidade=" + cidade
				+ ", livrosDesejados=" + livrosDesejados + ", livros=" + livros + "]";
	}

	
	
	
	
}
