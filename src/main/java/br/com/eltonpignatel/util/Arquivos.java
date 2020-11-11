package br.com.eltonpignatel.util;

import java.io.File;
import br.com.eltonpignatel.Leitor;

public class Arquivos {
	
	public static void criaDiretorioSeNaoExiste(String diretorio) {
		try {
			
            File novoDiretorio = new File(diretorio);
            if (!novoDiretorio.exists()) {
            	novoDiretorio.mkdir();
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	public static String urlExecucao(){
		String path = Leitor.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		
		if (path.endsWith("target/classes/")) {
			path = Leitor.class.getProtectionDomain().getCodeSource().getLocation().getPath().split("target/classes/")[0];
		}
		
		if (path.startsWith("/") && path.length() > 0 && identificarAmbiente().equals("Desenvolvimento")) {
			path = Leitor.class.getProtectionDomain().getCodeSource().getLocation().getPath().substring(1, path.length());
		}
		
		if (path.startsWith("/") && path.length() > 0 && identificarAmbiente().equals("Jar")) {
			path = Leitor.class.getProtectionDomain().getCodeSource().getLocation().getPath().substring(1, path.length());
			path = formaPastaDeArray(path.split("/"));
		}
		
		return path;
	}
	
	private static String formaPastaDeArray(String [] arrayPasta) {
		String novaUrl = "";
		for (int i = 0; i < arrayPasta.length-1; i++) {
			novaUrl += arrayPasta[i] + File.separator;
		}
		
		return novaUrl;
	}
	
	private static String identificarAmbiente() {
		
		if  (Leitor.class.getResource("Leitor.class").getProtocol().startsWith("file")) {
			return "Desenvolvimento";
		} else if (Leitor.class.getResource("Leitor.class").getProtocol().startsWith("jar")) {
			return "Jar";
		} else {
			return "Desconhecido";
		}
		
	}
	
}
