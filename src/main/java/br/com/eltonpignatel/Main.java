package br.com.eltonpignatel;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import br.com.eltonpignatel.dao.NotaCorretagemDAO;
import br.com.eltonpignatel.model.NotaCorretagem;

public class Main {
 
	public static void main(String[] args) throws IOException  {
		
		Leitor.criaEstruturaDiretorios();
		Leitor.processarArquivosPendentes();
		new LeitorClear().ler();
		
		List <NotaCorretagem> listaNotasCorretagem = new ArrayList<NotaCorretagem>();
		listaNotasCorretagem =  new NotaCorretagemDAO().lerTodos(NotaCorretagem.class);
		
		try {
			Leitor.createCSVFileFromListaCorretagem(listaNotasCorretagem);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}