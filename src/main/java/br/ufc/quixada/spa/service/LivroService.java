package br.ufc.quixada.spa.service;

import java.util.List;

import br.ufc.quixada.kisan.service.GenericService;
import br.ufc.quixada.spa.model.Livro;

public interface LivroService extends GenericService<Livro> {

	public Livro insereLivroEmWishList(Long idLivro, Long idUsuario);

	public String removeLivroDaWishList(Long idLivro, Long idUsuario);

	public List<Livro> findLivroUsuarioEmWishlist(Long idUsuario);

	public Long insereLivro(Livro livro, Long idUsuario);

	public String insereLivroEmWishListByIdFacebook(Long idLivro, Long idFacebookUsuario);

	public String removeLivroDaWishListByIdFacebook(Long idLivro, Long idFacebookUsuario);

	public List<Livro> findLivroUsuarioEmWishlistByIdFacebook(Long idFacebookUsuario);

	public void insereLivroByIdFacebook(Livro livro, Long idFacebookUsuario);
}
