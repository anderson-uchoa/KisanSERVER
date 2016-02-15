package br.ufc.quixada.spa.control;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



@Named
@RequestMapping("/file")
public class FileController {

	@Autowired
	private ServletContext context;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(method=RequestMethod.POST)
    public @ResponseBody String addImagem( @RequestParam("file") MultipartFile file){
		log.debug("Livro - PUT - FOTO");  
	 
		try {
			if (file.getBytes()!= null) {
					 	Util util = new Util();
					 	try {
					 		
						return util.inserirImagemDiretorio( file, context);
						} catch (Exception e) {
							e.printStackTrace();
						}	
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
		
	@RequestMapping(value = "/{nomeImagem}", method = RequestMethod.GET)
	public void getFile(@PathVariable("nomeImagem") String nomeImagem, HttpServletResponse response) {
		try {
			
				InputStream is = new FileInputStream(( new File (Constantes.URL_FILE + nomeImagem+".png")));
				response.setContentType("image/png");
				response.setHeader("Content-Disposition",
						"attachment; filename=" + nomeImagem.replace(" ", "_"));
				IOUtils.copy(is, response.getOutputStream());
				response.flushBuffer();
				
			}catch (IOException ex) {
			log.debug(ex.getMessage());
				throw new RuntimeException("IOError writing file to output stream");
		}
	}
	
}


