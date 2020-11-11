package br.com.eltonpignatel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;
import br.com.eltonpignatel.model.NotaCorretagem;
import br.com.eltonpignatel.model.NotaCorretagemLancto;
import br.com.eltonpignatel.util.Arquivos;
import br.com.eltonpignatel.util.Fmt;
import br.com.eltonpignatel.util.Formatos;

public class Leitor {
	
	static String diretorioBaseExecucao = Arquivos.urlExecucao();
	static String diretorioNotas = diretorioBaseExecucao + "notas" + File.separator;
	static String diretorioPendentes = diretorioNotas + "Pendentes" ;
	static String diretorioClear = diretorioNotas + "Clear";
	static String diretorioProcessados = diretorioNotas + "Processados";
	static String diretorioErros = diretorioNotas + "Erros";
	static String diretorioCSV = diretorioBaseExecucao +  "out" + File.separator ;
	 
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
		
	    FileWriter out = new FileWriter(diretorioCSV + "corretagens.csv");
	    
	    CSVPrinter printer = new CSVPrinter(out, CSVFormat.newFormat(';')
											    		.withQuote('"')
											    		.withRecordSeparator(System.getProperty("line.separator"))
											    		.withEscape('\\')
											    		.withQuoteMode(QuoteMode.ALL)
											    		.withHeader(HEADERS)
											    		);
	    	
    	for (NotaCorretagem notaCorretagem : listaNotasCorretagem) {
    		appendNotaCorretagemToCSVFile(printer, notaCorretagem);
    		printer.flush();
    	}
	   
	}
	
	private static void appendNotaCorretagemToCSVFile(CSVPrinter printer, NotaCorretagem notaCorretagem) throws IOException {
		
		for (NotaCorretagemLancto notaCorretagemLancto : notaCorretagem.getLanctos()) {
			System.out.println(notaCorretagemLancto.getEspecificacaoTitulo());
			printer.printRecord( notaCorretagem.getNumeroCorretagem(),
								 notaCorretagem.getCorretora(),
								 Formatos.formatar(notaCorretagem.getDataPregao(), Fmt.DDMMYYYY_BARRAS),
								 notaCorretagem.getValorLiquidoOperacoes() == null ? null : new DecimalFormat("#.0#").format(notaCorretagem.getValorLiquidoOperacoes()),
								 notaCorretagem.getTaxaLiquidacao() == null ? null : new DecimalFormat("#.0#").format(notaCorretagem.getTaxaLiquidacao()),
								 notaCorretagem.getTaxaRegistro() == null ? null : new DecimalFormat("#.0#").format(notaCorretagem.getTaxaRegistro()),
								 notaCorretagem.getTaxaTermoOpcoes() == null ? null : new DecimalFormat("#.0#").format(notaCorretagem.getTaxaTermoOpcoes()),
								 notaCorretagem.getTaxaANA() == null ? null : new DecimalFormat("#.0#").format(notaCorretagem.getTaxaANA()),
								 notaCorretagem.getEmolumentos() == null ? null : new DecimalFormat("#.0#").format(notaCorretagem.getEmolumentos()),
								 notaCorretagem.getTaxaOperacional() == null ? null : new DecimalFormat("#.0#").format(notaCorretagem.getTaxaOperacional()),
								 notaCorretagem.getExecucao() == null ? null : new DecimalFormat("#.0#").format(notaCorretagem.getExecucao()),
								 notaCorretagem.getTaxaCustodia() == null ? null : new DecimalFormat("#.0#").format(notaCorretagem.getTaxaCustodia()),
								 notaCorretagem.getImpostos() == null ? null : new DecimalFormat("#.0#").format(notaCorretagem.getImpostos()),
								 notaCorretagem.getBaseIRRF() == null ? null : new DecimalFormat("#.0#").format(notaCorretagem.getBaseIRRF()),
								 notaCorretagem.getValorIRRF() == null ? null : new DecimalFormat("#.0#").format(notaCorretagem.getValorIRRF()),
								 notaCorretagem.getOutros() == null ? null : new DecimalFormat("#.0#").format(notaCorretagem.getOutros()),
								 notaCorretagemLancto.getNegociacao(),
								 notaCorretagemLancto.getC_V(),
								 notaCorretagemLancto.getTipoMercado(),
								 notaCorretagemLancto.getEspecificacaoTitulo(),
								 notaCorretagemLancto.getQuantidade(),
								 notaCorretagemLancto.getPrecoAjuste()== null ? null : new DecimalFormat("#.0#").format(notaCorretagemLancto.getPrecoAjuste()),
								 notaCorretagemLancto.getValorOperacaoAjuste()== null ? null : new DecimalFormat("#.0#").format(notaCorretagemLancto.getValorOperacaoAjuste()),
								 notaCorretagemLancto.getD_C(),
								 notaCorretagemLancto.getFolha() );
		}
	}
	
	public static void criaEstruturaDiretorios() {
		
		Arquivos.criaDiretorioSeNaoExiste(diretorioCSV);
		Arquivos.criaDiretorioSeNaoExiste(diretorioNotas);
		Arquivos.criaDiretorioSeNaoExiste(diretorioPendentes);
		Arquivos.criaDiretorioSeNaoExiste(diretorioClear);
		Arquivos.criaDiretorioSeNaoExiste(diretorioProcessados);
		Arquivos.criaDiretorioSeNaoExiste(diretorioErros);
		
	}
}
