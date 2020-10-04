package br.com.eltonpignatel.dao;

import java.io.File;
import br.com.eltonpignatel.bd.Database;
import br.com.eltonpignatel.bd.IDatabase;
import br.com.eltonpignatel.model.NotaDeCorretagem;

public class NotaCorretagemDAO extends Database implements IDatabase {
	
	public NotaDeCorretagem lerJson(NotaDeCorretagem notaDeCorretagem) {
		// TODO Auto-generated method stub
		return (NotaDeCorretagem) super.lerJson(notaDeCorretagem, obterID(notaDeCorretagem));
	}
	
	public void gravarJson(NotaDeCorretagem notaDeCorretagem) {
		// TODO Auto-generated method stub
		super.gravarJson(notaDeCorretagem, obterID(notaDeCorretagem));
	}

	@Override
	public String obterID(Object objeto) {
		// TODO Auto-generated method stub
		return ((NotaDeCorretagem) objeto).getCorretora().toString() + File.pathSeparatorChar  +
				((NotaDeCorretagem) objeto).getNumeroCorretagem().toString();
	}

}