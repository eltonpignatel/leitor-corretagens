package br.com.eltonpignatel.dao;

import java.io.File;
import java.util.List;
import br.com.eltonpignatel.bd.Database;
import br.com.eltonpignatel.bd.IDatabase;
import br.com.eltonpignatel.model.NotaCorretagemLancto;
import br.com.eltonpignatel.model.NotaCorretagem;

public class NotaCorretagemDAO extends Database implements IDatabase {
	
	public NotaCorretagem lerJson(NotaCorretagem notaCorretagem) {

		return (NotaCorretagem) super.lerJson(notaCorretagem.getClass(), obterID(notaCorretagem));
	}
	
	public void gravarJson(NotaCorretagem notaCorretagem) {
		
		Boolean jaTemFolha = false;
		
		NotaCorretagem notaCorretagemBD = new NotaCorretagem();
		notaCorretagemBD = lerJson(notaCorretagem); 
		
		if ( notaCorretagemBD != null ) {
			
			for (NotaCorretagemLancto lancto : notaCorretagemBD.getLanctos()) {
				if ( lancto.getFolha() == notaCorretagem.getLanctos().get(0).getFolha() ) {
					jaTemFolha = true;
				}
			}
			
			if (!jaTemFolha) {
				for (NotaCorretagemLancto lancto : notaCorretagem.getLanctos()) {
					notaCorretagemBD.getLanctos().add(lancto);
				}
			}
			
		} else {
			notaCorretagemBD  = notaCorretagem;
		}
		
		super.gravarJson(notaCorretagemBD, obterID(notaCorretagemBD));
	}
	
	public void apagarJson(NotaCorretagem notaCorretagemo) {
		
		super.apagarJson(notaCorretagemo, obterID(notaCorretagemo));
		
	}
	
	@SuppressWarnings("unchecked")
	public  List<NotaCorretagem> lerTodos(Class<?> classe) {
		return (List<NotaCorretagem>) super.lerTodos(classe);
	}

	public String obterID(Object objeto) {
		return ((NotaCorretagem) objeto).getCorretora().toString() + File.pathSeparatorChar  +
				((NotaCorretagem) objeto).getNumeroCorretagem().toString();
	}

}