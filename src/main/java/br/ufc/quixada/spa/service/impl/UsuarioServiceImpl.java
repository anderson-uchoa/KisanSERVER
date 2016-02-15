package br.ufc.quixada.spa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;
import javax.transaction.Transactional;

import br.ufc.quixada.kisan.enumeration.QueryType;
import br.ufc.quixada.kisan.service.impl.GenericServiceImpl;

import br.ufc.quixada.spa.model.Livro;
import br.ufc.quixada.spa.model.Usuario;

import br.ufc.quixada.spa.service.UsuarioService;

@Named
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario> implements UsuarioService {

	
	
	@Override
	public List<Livro> findLivrosById(Long id) {
		Usuario usuario = find(Usuario.class, id);
		return usuario.getLivros();

	}

	@Override
	public Usuario findUsuarioByIdFacebook(Long idFacebook) {

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("idFacebook", idFacebook);
			List<Usuario> result = find(QueryType.JPQL, "from Usuario where id_facebook  = :idFacebook", params);
			if(result != null && !result.isEmpty()) {
				return result.get(0);
			}
			return null;
		}

	
	
}
	

