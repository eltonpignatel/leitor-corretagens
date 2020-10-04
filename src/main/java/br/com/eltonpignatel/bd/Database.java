package br.com.eltonpignatel.bd;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

public class Database {
	
	protected void gravarJson(Object objeto, String id) {
		
		try {
			
			criarPastaDatabase();
			
			criarPastaObjeto(objeto.getClass().getSimpleName());

			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objeto);
			 
			Files.write(Paths.get("database" + File.separatorChar + 
					objeto.getClass().getSimpleName() + File.separatorChar + 
					id + ".json"), jsonInString.getBytes());
		    
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	protected Object lerJson(Object objeto, String id) {
		
		Object objetoPreenchido = null;
		
	    try {
	    	
	    	String json = new String ( Files.readAllBytes( Paths.get("database" + File.separatorChar + 
					objeto.getClass().getSimpleName() + File.separatorChar + 
					id + ".json") ) );
	    	
	    	ObjectMapper objectMapper = new ObjectMapper();
	    	objetoPreenchido = objectMapper.readValue( json, objeto.getClass() );
	    	
	    } catch (MismatchedInputException mie) {
	    	return null;
	    }
	    catch (IOException e) {
	    	return null;
	    }
	    
	    return objetoPreenchido;
	    
	}
	
	private void criarPastaDatabase() {
		
		try {
			
            File diretorio = new File("database");
            if (!diretorio.exists()) {
            	diretorio.mkdir();
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
	}
	
	private void criarPastaObjeto(String nome) {
		
		try {
			
            File diretorio = new File("database" + File.separatorChar + nome);
            if (!diretorio.exists()) {
            	diretorio.mkdir();
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
	}	

}
