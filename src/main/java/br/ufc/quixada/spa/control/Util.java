package br.ufc.quixada.spa.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.inject.Named;
import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;



public class Util {
	
//	@Autowired
//	private static ServletContext context;
	
	//private static final String PATH = context.getRealPath("/resources/upload/");
			
	private DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	private Logger log = LoggerFactory.getLogger(this.getClass());
    public String inserirImagemDiretorio(MultipartFile item, ServletContext context ) throws Exception{
    	
        final String PATH_ARQUIVOS  = context.getRealPath("/resources/upload/");
    	log.debug(PATH_ARQUIVOS); 
        final String PATH_ABSOLUTO  = (PATH_ARQUIVOS );

        try {

            File diretorio  = new File(PATH_ABSOLUTO);
           
            if(!diretorio.exists())
                diretorio.mkdir();

            String fileName = new Random().nextInt(99999999)+ new Date().getTime()+".png";
            String arq[] = fileName.split("\\\\");
            for (int i = 0; i < arq.length; i++) {
                fileName = arq[i];
            }

            File file = new File(diretorio,fileName);
            
            FileOutputStream out = new FileOutputStream(file);
            InputStream in = item.getInputStream();    

            
            byte[] buffer = new byte[1024 * 10];
            int nLidos;
            while ((nLidos = in.read(buffer)) >= 0) {
                out.write(buffer, 0, nLidos);
            }

            out.flush();
            out.close();


            // NO FINAL ELE TE RETORNA O CAMINHO DA PASTA ONDE VC SALVOU A IMAGEN
            // ESSA STRING VC PODE ARMAZENAR NA TABELA DO PRODUTO
            // NO CAMPO : CAMINHO_FOTO
           return fileName;
           

        } catch (Exception e) {
            throw new Exception("Erro ao carregar imagem para o diretorio !!\n "
                    + "Error : "      + e.getMessage() 
                    + "\nCausa : " + e.getCause());
        }

    }
	
	
}
