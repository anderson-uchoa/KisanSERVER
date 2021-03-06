package br.ufc.quixada.spa.control;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.quixada.kisan.enumeration.ResponseStatus;
import br.ufc.quixada.kisan.model.ResponseStatusMessage;
import br.ufc.quixada.spa.model.Livro;
import br.ufc.quixada.spa.service.LivroService;


@Named
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private ServletContext context;

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private LivroService livroService;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Livro> findAll() {
		log.debug("Livro - GET (all)");
		 List<Livro> livros = livroService.find(Livro.class);
		 return livros;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody Livro findById(@PathVariable Long id) {
		log.debug("Livro - GET (id)");
	
		return livroService.find(Livro.class, id);
	}
	

	@RequestMapping(value="/livrosUsuarioWishList/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Livro> findLivrosUsuarioById(@PathVariable Long id) {
		log.debug("WishList - GET (id) - findLivrosById");
		return livroService.findLivroUsuarioEmWishlist(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Long insert(@RequestBody Livro livro) {
			log.debug("Livro - POST:" + livro.toString());
			Long id = livroService.insereLivro(livro, livro.getUsuario().getId());
			log.debug("Livro - POST:" + id);
			return id;
	}

	
	
	@RequestMapping(value="/insereLivroWishList/{id}", method = RequestMethod.POST)
	public @ResponseBody Livro insereLivroEmWishList(@RequestBody Livro livro,  @PathVariable Long id ) {
		log.debug("WishList - POST - insere livro na wishlist");
		return livroService.insereLivroEmWishList(livro.getId(), id);
		
	}
	
	

	@RequestMapping(value="/removerLivroWishList/{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseStatusMessage removeLivroDaWishList(@RequestBody Livro livro, @PathVariable Long id  ) {
		log.debug("WishList - DELETE");
		String msg = livroService.removeLivroDaWishList(livro.getId(),id);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, msg);
	}
	

	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public @ResponseBody ResponseStatusMessage update(Livro livro, @PathVariable Long id) {
		log.debug("Livro - PUT");
		livro.setId(id);
		log.debug("Updating Livro: {}", livro);
		livroService.update(livro);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Livro atualizada com sucesso");
	}
	
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseStatusMessage delete(@PathVariable Long id) {
		log.debug("Livro - DELETE");
		Livro livro = livroService.find(Livro.class, id);
		livroService.removeLivroDaWishList(livro.getId(), livro.getUsuario().getId());
		livroService.delete(livro);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Livro removida com sucesso");
	}
}
