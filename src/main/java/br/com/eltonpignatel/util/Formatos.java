package br.com.eltonpignatel.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatos {
	
	public static String formatar(Date data, Fmt formato) {
		return new SimpleDateFormat(formato.valor).format(data);
	}
	
	public static String formatar(Double numero, Fmt formato) {
		return new DecimalFormat("#.0#").format(numero);
	}

}
