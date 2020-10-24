package br.com.eltonpignatel.bd;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
	
	protected void apagarJson(Object objeto, String id) {
		
		try {

			File arquivoJson = new File("database" + File.separatorChar + 
					objeto.getClass().getSimpleName() + File.separatorChar + 
					id + ".json");
			
			if (arquivoJson.exists()) {
				arquivoJson.delete();
			}
			
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	protected List<?> lerTodos(Class<?> classe) {
		
		criarPastaDatabase();
		
		criarPastaObjeto(classe.getSimpleName());
		
		File diretorioArquivos = new File("database" + File.separator + classe.getSimpleName() );
		
		File[] arquivos = diretorioArquivos.listFiles();
		
		List <Object> registros = new ArrayList<Object>();
		
		for (File arquivo : arquivos ) {
			
			registros.add(lerJson(classe, arquivo.getName().split("\\.")[0]));
		
		}
		
		return registros;
	}
	
	protected Object lerJson(Class<?> classe, String id) {
		
		Object objetoPreenchido = null;
		
	    try {
	    	
	    	String json = new String ( Files.readAllBytes( Paths.get("database" + File.separatorChar + 
	    			classe.getSimpleName() + File.separatorChar + 
					id + ".json") ) );
	    	
	    	ObjectMapper objectMapper = new ObjectMapper();
	    	objetoPreenchido = objectMapper.readValue( json, classe );
	    	
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
