package br.com.eltonpignatel.util;

public enum Fmt {
	
	DDMMYYYY_BARRAS("dd/MM/YYYY");
	
	public final String valor;

	Fmt(String valorFormato) {
		valor = valorFormato;
	}
}
