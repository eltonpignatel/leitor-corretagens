package br.com.eltonpignatel.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatos {
	
	public static String formatar(Date data, Fmt formato) {
		return new SimpleDateFormat(formato.valor).format(data);
	}

}
