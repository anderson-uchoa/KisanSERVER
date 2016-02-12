package br.ufc.quixada.spa.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.ufc.quixada.kisan.enumeration.QueryType;
import br.ufc.quixada.kisan.service.impl.GenericServiceImpl;
import br.ufc.quixada.kisan.util.SimpleMap;
import br.ufc.quixada.spa.model.Livro;

import br.ufc.quixada.spa.model.Usuario;
import br.ufc.quixada.spa.service.LivroService;

import br.ufc.quixada.spa.service.UsuarioService;

@Named
public class LivroServiceImpl  extends GenericServiceImpl<Livro> implements LivroService{

	
	@Inject
	private UsuarioService usuarioService;

	
	@Transactional
	@Override
	public String insereLivroEmWishList(Long idLivro, Long idUsuario) {

		Livro livro = find(Livro.class, idLivro);
		Usuario usuario = usuarioService.find(Usuario.class, idUsuario);
		System.out.println("nome : "+usuario.getId());
		if (!findLivroEmWishlist(idLivro, idUsuario)) {
			usuario.getLivrosDesejados().add(livro);
			usuarioService.update(usuario);
			return "Livro inserido com sucesso na wishList";
		} else {
			return "Livro já estava cadastrado na wishList";
		}
	}
	
	@Transactional
	@Override
    public void insereLivro(Livro livro, Long idUsuario) {
		Usuario usuario = usuarioService.find(Usuario.class, idUsuario);
		usuario.getLivros().add(livro);	
		save(livro);
		
	}

	@Transactional
	@Override
	public String removeLivroDaWishList(Long idLivro, Long idUsuario) {
		
		int n = executeUpdate("delete from livros_desejados where livro_id = :idLivro and usuario_id = :idUsuario",
				new SimpleMap<String, Object>("idLivro", idLivro, "idUsuario", idUsuario));
		if (n == 0) {	
			return "Livro não estava cadastrado na WishList";
		} else {
			return "Livro removido com sucesso da WishList";
		}	
	
	}


	@Override
	public List<Livro> findLivroUsuarioEmWishlist( Long idUsuario) {
		Usuario usuario = usuarioService.find(Usuario.class, idUsuario);
		List<Livro> livros = usuario.getLivrosDesejados();
		return livros;
	
	}
	
	private boolean findLivroEmWishlist(Long idLivro, Long idUsuario) {
		Object obj = findFirst(QueryType.NATIVE,
				"select * from livros_desejados where livro_id = :idLivro and usuario_id = :idUsuario",
				new SimpleMap<String, Object>("idLivro", idLivro, "idUsuario", idUsuario));
		return obj != null;
	}

	@Override
	public String insereLivroEmWishListByIdFacebook(Long idLivro, Long idFacebookUsuario) {
		return null;
	}

	@Override
	public String removeLivroDaWishListByIdFacebook(Long idLivro, Long idFacebookUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Livro> findLivroUsuarioEmWishlistByIdFacebook(Long idFacebookUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insereLivroByIdFacebook(Livro livro, Long idFacebookUsuario) {
		// TODO Auto-generated method stub
		
	}

	

	
}
