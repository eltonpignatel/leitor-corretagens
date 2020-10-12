package br.com.eltonpignatel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;
import br.com.eltonpignatel.model.NotaCorretagem;
import br.com.eltonpignatel.model.NotaCorretagemLancto;
import br.com.eltonpignatel.util.Fmt;
import br.com.eltonpignatel.util.Formatos;

public class Leitor {
	
	static String diretorioPendentes = "notas" + File.separator + "pendentes" ;
	static String diretorioClear = "notas" + File.separator + "Clear";
	static String diretorioProcessados = "notas" + File.separator + "Processados";
	static String diretorioErros = "notas" + File.separator + "Erros";
	
	public static void processarArquivosPendentes() throws IOException {
		
		File diretorioArquivos = new File(diretorioPendentes);
		File[] arquivos  = diretorioArquivos.listFiles();
		
		for (File arquivo : arquivos) {
			Files.move(arquivo.toPath(), Paths.get( diretorioClear + File.separator +  arquivo.getName() ), StandardCopyOption.REPLACE_EXISTING);
		}
	}
	
	public static void createCSVFileFromListaCorretagem(List <NotaCorretagem> listaNotasCorretagem) throws IOException {
		
		String[] HEADERS = { "NumeroCorretagem", "Corretora", "Data Pregão", "ValorLiquidoOperacoes", "TaxaLiquidacao",
						 	 "TaxaRegistro", "TaxaTermoOpcoes", "TaxaANA", "Emolumentos", "TaxaOperacional", "Execucao", 
							 "TaxaCustodia", "Impostos", "BaseIRRF", "ValorIRRF", "Outros", "Negociacao", "C_V", 
							 "Tipo Mercado", "Especificacao Titulo", "Quantidade", "PrecoAjuste", "ValorOperacaoAjuste",
							 "D_C", "Folha" };
		
	    FileWriter out = new FileWriter("out\\corretagens.csv");
	    
	    CSVPrinter printer = new CSVPrinter(out, CSVFormat.newFormat(';')
											    		.withQuote('"')
											    		.withRecordSeparator("\r\n")
											    		.withEscape('\\')
											    		.withQuoteMode(QuoteMode.ALL)
											    		.withHeader(HEADERS));
	    	
    	for (NotaCorretagem notaCorretagem : listaNotasCorretagem) {
    		appendNotaCorretagemToCSVFile(printer, notaCorretagem);
    	}
	   
	}
	
	private static void appendNotaCorretagemToCSVFile(CSVPrinter printer, NotaCorretagem notaCorretagem) throws IOException {
		
		for (NotaCorretagemLancto notaCorretagemLancto : notaCorretagem.getLanctos()) {
			
			printer.printRecord( notaCorretagem.getNumeroCorretagem(),
								 notaCorretagem.getCorretora(),
								 Formatos.formatar(notaCorretagem.getDataPregao(), Fmt.DDMMYYYY_BARRAS),
								 notaCorretagem.getValorLiquidoOperacoes(),
								 notaCorretagem.getTaxaLiquidacao(),
								 notaCorretagem.getTaxaRegistro(),
								 notaCorretagem.getTaxaTermoOpcoes(),
								 notaCorretagem.getTaxaANA(),
								 notaCorretagem.getEmolumentos(),
								 notaCorretagem.getTaxaOperacional(),
								 notaCorretagem.getExecucao(),
								 notaCorretagem.getTaxaCustodia(),
								 notaCorretagem.getImpostos(),
								 notaCorretagem.getBaseIRRF(),
								 notaCorretagem.getValorIRRF(),
								 notaCorretagem.getOutros(),
								 notaCorretagemLancto.getNegociacao(),
								 notaCorretagemLancto.getC_V(),
								 notaCorretagemLancto.getTipoMercado(),
								 notaCorretagemLancto.getEspecificacaoTitulo(),
								 notaCorretagemLancto.getQuantidade(),
								 notaCorretagemLancto.getPrecoAjuste(),
								 notaCorretagemLancto.getValorOperacaoAjuste(),
								 notaCorretagemLancto.getD_C(),
								 notaCorretagemLancto.getFolha() );
		}
	}
}
