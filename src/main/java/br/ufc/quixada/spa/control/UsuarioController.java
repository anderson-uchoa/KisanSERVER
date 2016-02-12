package br.ufc.quixada.spa.control;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufc.quixada.kisan.enumeration.ResponseStatus;
import br.ufc.quixada.kisan.model.ResponseStatusMessage;
import br.ufc.quixada.spa.model.Livro;
import br.ufc.quixada.spa.model.Usuario;
import br.ufc.quixada.spa.service.UsuarioService;


@Named
@RequestMapping("/usuario")
public class UsuarioController {

	
private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/livros/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Livro> findLivrosById(@PathVariable Long id) {
		log.debug("Usuario - GET (id) - findLivrosById");
		return usuarioService.findLivrosById(id);
	}
	

	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody Usuario findById(@PathVariable Long id) {
		log.debug(" Usuario - GET (id)");
		return usuarioService.find(Usuario.class, id);
	}
	
	@RequestMapping(value="/buscarIdFacebook/{idFacebook}", method = RequestMethod.GET)
	public @ResponseBody Usuario findByIdFacebook(@PathVariable Long idFacebook) {
		log.debug(" Usuario - GET (idFacebook) ");
		return usuarioService.findUsuarioByIdFacebook(idFacebook);
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Usuario> findAll() {
		log.debug("Usuario - GET (all)");
		return usuarioService.find(Usuario.class);
	}
	

	@RequestMapping( method = RequestMethod.POST)
	public @ResponseBody ResponseStatusMessage insert(@RequestBody Usuario usuario) {
		log.debug("Usuario - POST");
		usuarioService.save(usuario);
		return new ResponseStatusMessage(ResponseStatus.SUCCESS, "Usuario inserida com sucesso");
	}
	

	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody Usuario atualizar(@RequestBody Usuario usuario) {
		log.debug("Usuario - PUT");
		usuarioService.update(usuario);
		return usuarioService.find(Usuario.class, usuario.getId());
	}
	
	
}
