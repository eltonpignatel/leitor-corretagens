package br.com.eltonpignatel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.eltonpignatel.dao.NotaCorretagemDAO;
import br.com.eltonpignatel.model.NotaCorretagem;

public class Main {
 
	public static void main(String[] args) throws IOException  {
		
		Leitor.criaEstruturaDiretorios();
		Leitor.processarArquivosPendentes();
		new LeitorClearRico().ler();
		
		List <NotaCorretagem> listaNotasCorretagem = new ArrayList<NotaCorretagem>();
		listaNotasCorretagem =  new NotaCorretagemDAO().lerTodos(NotaCorretagem.class);
		
		try {
			Leitor.createCSVFileFromListaCorretagem(listaNotasCorretagem);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "Fim de execução da rotina de importação");
		
	}

}